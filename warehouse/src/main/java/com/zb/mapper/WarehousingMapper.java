package com.zb.mapper;

import com.zb.pojo.Warehousing;
import org.apache.ibatis.annotations.Mapper;

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
}
