package com.zb.mapper;

import com.zb.pojo.DetailedWarehousing;
import com.zb.pojo.Warehousing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface WarehousingMapper {

    /** 查询所有*/
    List<Warehousing> selectAll();

    /** 根据id查询*/
    Warehousing selectById(Long id);

    /**
     * 入库前盛和
     * @param warehousing 入库订单
     * @return
     */
    Integer checkBeforeStorage(Warehousing warehousing);

    /**
     * 添加入库订单
     * @param warehousing
     * @return
     */
    Integer insert(Warehousing warehousing);

    /**
     * 根据入库状态查询
     * @param status
     * @return
     */
    List<Warehousing> selectByStatus(Integer[] status);

    /**
     * 添加入库审核详细订单
     * @param detailedWarehousing
     * @return
     */
    Integer insertDetailedWarehousing(DetailedWarehousing detailedWarehousing);

    /**
     * 修改入库流程单
     * @param warehousing
     * @return
     */
    Integer update(Warehousing warehousing);

    /**
     * 根据入库流程单展示入库详细单
     * @param warehousingId
     * @return
     */
    List<DetailedWarehousing> selectDetailedWarehousingByWarehousingId(Long warehousingId);

    /**
     * 修改入库详细单
     * @param detailedWarehousing
     * @return
     */
    Integer UpdateDetailedWarehousing(DetailedWarehousing detailedWarehousing);

    /**
     * 修改入库详细单状态
     * @param detailedWarehousing
     * @return
     */
    Integer UpdateDetailedWarehousingStatus(DetailedWarehousing detailedWarehousing);
}
