package com.zb.service.impl;

import com.zb.mapper.SortMapper;
import com.zb.pojo.Sort;
import com.zb.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SortServiceImpl implements SortService {
    @Autowired(required = false)
    private SortMapper sortMapper;
    @Override
    public List<Sort> listSort() {
        return sortMapper.listSort();
    }
}
