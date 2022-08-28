package com.zb.service.impl;

import com.zb.mapper.WarehousingMapper;
import com.zb.pojo.*;
import com.zb.service.DetailedPurchaseService;
import com.zb.service.WarehouseService;
import com.zb.service.WarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class WarehousingServiceImpl implements WarehousingService {

    @Autowired
    private WarehousingMapper warehousingMapper;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private DetailedPurchaseService detailedPurchaseService;

    /**
     * 查询全部
     *
     * @return
     */
    @Override
    public List<Warehousing> findAll() {
        return warehousingMapper.selectAll();
    }

    /**
     * 入库前审核
     *
     * @param warehousing 审核订单
     * @param loginUser   登录用户（审核人）
     * @return
     */
    @Override
    public Integer checkBeforeStorage(Warehousing warehousing, User loginUser) {

        Long detailedPurchaseId = warehousing.getDetailedPurchaseId();

        Integer result = 0;
        List<DetailedWarehousing> detailedWarehousingList = warehousing.getDetailedWarehousingList();
        for (DetailedWarehousing detailedWarehousing : detailedWarehousingList) {
            result += warehousingMapper.UpdateDetailedWarehousing(detailedWarehousing);
        }


        warehousing.setExamineUserId(loginUser.getId());
        warehousing.setExamineTime(new Date(System.currentTimeMillis()));
        warehousing.setStatus(result > 0 ? 2 : 3);
        return warehousingMapper.checkBeforeStorage(warehousing);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Warehousing findById(Long id) {
        return warehousingMapper.selectById(id);
    }

    /**
     * 创建入库流程单
     *
     * @param purchase 进货订单
     * @return
     */
    @Override
    public Integer createWarehousing(Purchase purchase) {
        Long purchaseId = purchase.getId();
        List<DetailedPurchase> list = detailedPurchaseService.selectByPurchaseId(purchaseId);

        //添加入库流程
        Warehousing warehousing = new Warehousing();
        warehousing.setPurchaseId(purchaseId);
        warehousing.setStatus(0);
        warehousing.setCreateTime(new Date(System.currentTimeMillis()));

        warehousingMapper.insert(warehousing);

        Integer sum = 0;

        for (DetailedPurchase detailedPurchase : list) {
            if (detailedPurchase.getStatus() == 1) {
                // 将需要的DetailedPurchase存入DetailedWarehousing中
                DetailedWarehousing detailedWarehousing = new DetailedWarehousing();
                detailedWarehousing.setWarehousingId(warehousing.getId());
                detailedWarehousing.setVendorId(detailedPurchase.getVendorId());
                detailedWarehousing.setSkuId(detailedPurchase.getSkuId());
                String batch = UUID.randomUUID().toString().substring(0, 6);
                detailedWarehousing.setBatch(batch);
                detailedWarehousing.setPurchasePrice(detailedPurchase.getPurchasePrice());
                detailedWarehousing.setNumber(detailedPurchase.getNumber());

                sum += detailedPurchase.getNumber();

                Integer integer1 = warehousingMapper.insertDetailedWarehousing(detailedWarehousing);
                if (integer1 <= 0) {
                    return -1;
                }
                // 修改DetailedPurchase状态为4（订单完成）
                DetailedPurchase d = new DetailedPurchase();
                d.setId(detailedPurchase.getId());
                d.setStatus(4);
                Integer integer = detailedPurchaseService.modifyById(d);
                if (integer <= 0) {
                    return -1;
                }

            }
        }
        warehousing.setWarehousingNumber(sum);
        warehousingMapper.update(warehousing);
        return 1;
    }

    /**
     * 入库审核
     *
     * @param warehousing 审核订单
     * @param loginUser   登录用户（审核人）
     * @return
     */
    @Override
    public Integer inventoryAudit(Warehousing warehousing, User loginUser) {

        warehousing.setWarehousingUserId(loginUser.getId());
        warehousing.setWarehousingTime(new Date(System.currentTimeMillis()));
        warehousing.setStatus(200);
        // 入库审核
        Integer insert = warehousingMapper.checkBeforeStorage(warehousing);

        //
        List<DetailedWarehousing> detailedWarehousingList = warehousing.getDetailedWarehousingList();
        for (DetailedWarehousing detailedWarehousing : detailedWarehousingList) {
            detailedWarehousing.setStatus(1);

            Warehouse w = new Warehouse();
            w.setCreateUserId(loginUser.getId());
            w.setCreateTime(new Date(System.currentTimeMillis()));
            w.setPhone(loginUser.getPhone());
            w.setDetailedWarehousingId(detailedWarehousing.getId());
            w.setStockNumber(detailedWarehousing.getNumber());
            w.setWarehouseAddress("1号仓库");
            w.setSkuId(detailedWarehousing.getSkuId());
            w.setBatch(UUID.randomUUID().toString().replaceAll("-", ""));
            w.setCreateUserId(warehousing.getWarehousingUserId());

            warehouseService.add(w);
            warehousingMapper.UpdateDetailedWarehousing(detailedWarehousing);

        }

        return 1;
    }

    /**
     * 查询入库前审核列表
     *
     * @return
     */
    @Override
    public List<Warehousing> findAuditWarehousing() {
        // 审核状态
        Integer[] status = {0};
        return warehousingMapper.selectByStatus(status);
    }

    /**
     * 查询入库审核列表
     *
     * @return
     */
    @Override
    public List<Warehousing> findInventoryAudit() {
        // 审核状态
        Integer[] status = {2, 3};
        return warehousingMapper.selectByStatus(status);
    }

    @Override
    public Integer insertDetailedWarehousing(DetailedWarehousing detailedWarehousing) {
        return warehousingMapper.insertDetailedWarehousing(detailedWarehousing);
    }

    @Override
    public List<DetailedWarehousing> findDetailedWarehousingByWarehousingId(Long warehousingId) {
        return warehousingMapper.selectDetailedWarehousingByWarehousingId(warehousingId);
    }
}
