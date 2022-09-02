package com.zb.service.impl;

import com.zb.pojo.SalesDetails;
import com.zb.service.retailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class retailServiceImpl implements retailService {
    @Autowired(required = false)
    private com.zb.mapper.retailMapper retailMapper;

    @Override
    public List<SalesDetails> listSalesDetailsByName(String name) {
        return retailMapper.listSalesDetailsByName(name);
    }

    @Override
    public List<SalesDetails> listSalesDetailsById(Integer id) {
        return retailMapper.listSalesDetailsById(id);
    }

    @Override
    public List<SalesDetails> listSalesDetails() {
        return retailMapper.listSalesDetails();
    }
}
