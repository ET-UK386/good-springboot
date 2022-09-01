package com.zb.mapper;

import com.zb.pojo.SalesDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface retailMapper {
    List<SalesDetails> listSalesDetails();
}
