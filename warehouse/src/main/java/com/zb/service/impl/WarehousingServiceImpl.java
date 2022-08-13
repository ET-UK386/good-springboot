package com.zb.service.impl;

import com.zb.mapper.WarehousingMapper;
import com.zb.pojo.Warehousing;
import com.zb.service.WarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WarehousingServiceImpl implements WarehousingService {

    @Autowired
    private WarehousingMapper warehousingMapper;

    @Override
    public List<Warehousing> findAll() {
        return warehousingMapper.selectAll();
    }
}
