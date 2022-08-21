package com.zb.service.impl;


import com.zb.mapper.GoodMapper;
import com.zb.pojo.*;

import com.zb.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional
public class GoodServiceImpl implements GoodService {
    /**
     * 查询所有商品
     *
     * @return
     */

    @Autowired(required = false)
    private GoodMapper goodMapper;

    /**
     * 根据商品名或分类查询
     *
     *
     * @param skuName
     * @param sortName
     * @return
     */
    @Override
    public List<Goodsku> fingByskuNameorSortName(String skuName, String sortName) {
        return goodMapper.fingByskuNameorSortName(skuName,sortName);
    }

    /**
     * 查询商品具体信息
     *
     * @return
     */
    @Override
    public List<Goodsku> findAllGoodsku() {
        return goodMapper.findAllGoodsku();
    }

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    @Override
    public int updateLogic_status(Integer id) {
        return goodMapper.updateLogic_status(id);
    }

    /**
     * 查询所有条数
     *
     * @return
     */
    @Override
    public int count() {
        return goodMapper.count();
    }

    /**
     * 向spu添加数据
     *
     * @param sp
     * @return
     */
    @Override
    public int insertGoodspu(Goodspu sp) {
        return goodMapper.insertGoodspu(sp);
    }

    @Override
    public List<Goodsku> listGood() {
        return goodMapper.listGood();
    }

    /**
     * 修改颜色
     *
     * @param c
     * @return
     */
    @Override
    public int updateColor(Color c) {
        return goodMapper.updateColor(c);
    }

    /**
     * 修改经销商
     *
     * @param v
     * @return
     */
    @Override
    public int updateVendor(Vendor v ) {
        return goodMapper.updateVendor(v);
    }

    /**
     * 修改库存
     *
     * @param w
     * @return
     */
    @Override
    public int updateWarehouse(Warehouse w) {
        return goodMapper.updateWarehouse(w);
    }

    /**
     * 查找价格
     *
     * @param price
     * @return
     */
    @Override
    public Price findPriceTwo(double price) {
        return goodMapper.findPriceTwo(price);
    }

    /**
     * 查找库存
     *
     * @param stockNumber
     * @return
     */
    @Override
    public int findWarehouseTwo(Integer stockNumber) {
        return goodMapper.findWarehouseTwo(stockNumber);
    }

    /**
     * 查找经销商
     *
     * @param vendorName
     * @return
     */
    @Override
    public Vendor findVendorTwo(String vendorName) {
        return goodMapper.findVendorTwo(vendorName);
    }

    /**
     * 查找经销商
     *
     * @param vendorName
     * @return
     */
    @Override
    public int findVendor(String vendorName) {
        return goodMapper.findVendor(vendorName);
    }

    /**
     * 查找库存
     *
     * @param stockNumber
     * @return
     */
    @Override
    public Warehouse findWarehouse(Integer stockNumber) {
        return goodMapper.findWarehouse(stockNumber);
    }

    /**
     * 修改单位
     *
     * @param u
     * @return
     */
    @Override
    public int updateUnits(Units u) {
        return goodMapper.updateUnits(u);
    }

    /**
     * 修改sku价格
     *
     * @param g
     * @return
     */
    @Override
    public int updateGoodskuPrice(Goodsku g) {
        return goodMapper.updateGoodskuPrice(g);
    }

    /**
     * 查找价格id
     *
     * @param price
     * @return
     */
    @Override
    public int findPrice(double price) {
        return goodMapper.findPrice(price);
    }

    /**
     * 修改价格
     *
     * @param p
     * @return
     */
    @Override
    public int updatePrice(Price p) {
        return goodMapper.updatePrice(p);
    }

    /**
     * 修改分类
     *
     * @param s
     * @return
     */
    @Override
    public int updateSort(Sort s) {
        return goodMapper.updateSort(s);
    }

    /**
     * 查找spu
     *
     * @param id
     * @return
     */
    @Override
    public Goodspu findspu(Integer id) {
        return goodMapper.findspu(id);
    }

    /**
     * 修改spu
     *
     * @return
     */
    @Override
    public int updateSpu(Goodspu g) {
        return goodMapper.updateSpu(g);
    }

    /**
     * 修改商品
     *
     * @param g
     * @return
     */
    @Override
    public int updateGood(Goodsku g) {
        return goodMapper.updateGood(g);
    }

    /**
     * 添加供应商
     *
     * @param v
     * @return
     */
    @Override
    public int insertvendor(Vendor v) {
        return goodMapper.insertvendor(v);
    }


    /**
     * 查找颜色ID
     *
     * @param colorName
     * @return
     */
    @Override
    public Color findColor(String colorName) {
        return goodMapper.findColor(colorName);
    }

    /**
     * 添加价格
     *
     * @param p
     * @return
     */
    @Override
    public int insertprice(Price p) {
        return goodMapper.insertprice(p);
    }

    /**
     * 查找所属分类
     *
     * @param sortName
     * @return
     */
    @Override
    public Sort findSort(String sortName) {
        return goodMapper.findSort(sortName);
    }

    /**
     * 添加分类
     *
     * @param s
     * @return
     */
    @Override
    public int insertSort(Sort s) {
        return goodMapper.insertSort(s);
    }

    /**
     * 添加库存
     *
     * @param w
     * @return
     */
    @Override
    public int insertStock(Warehouse w) {
        return goodMapper.insertStock(w);
    }

    /**
     * 添加商品
     *
     * @param g
     * @return
     */
    @Override
    public int insertGood(Goodsku g) {
        return goodMapper.insertGood(g);
    }


    /**
     * 查找单位
     *
     * @param unitsName
     * @return
     */
    @Override
    public Units findUnits(String unitsName) {
        return goodMapper.findUnits(unitsName);
    }
}
