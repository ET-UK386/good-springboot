package com.zb.service;

import com.zb.pojo.SalesDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface retailService {
    List<SalesDetails> listSalesDetails();

    List<SalesDetails> listSalesDetailsByName(String name);

    List<SalesDetails> listSalesDetailsById(Integer id);
}
