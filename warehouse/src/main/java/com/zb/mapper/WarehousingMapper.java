package com.zb.mapper;

import com.zb.pojo.Warehousing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehousingMapper {

    /** 查询所有*/
    List<Warehousing> selectAll();


}
