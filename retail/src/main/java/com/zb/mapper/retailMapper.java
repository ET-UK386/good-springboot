package com.zb.mapper;

import com.zb.pojo.SalesDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface retailMapper {
    List<SalesDetails> listSalesDetails();

    List<SalesDetails> listSalesDetailsByName(@Param("name") String name);

    List<SalesDetails> listSalesDetailsById(@Param("id") Integer id);

    Integer updateSalesDetailsById(@Param("id") Integer id);
}
