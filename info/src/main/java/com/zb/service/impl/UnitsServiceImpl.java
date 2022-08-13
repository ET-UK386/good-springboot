package com.zb.service.impl;

import com.zb.mapper.UnitsMapper;
import com.zb.pojo.Units;
import com.zb.service.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UnitsServiceImpl implements UnitsService {
    @Autowired(required = false)
    private UnitsMapper unitsMapper;

    @Override
    public List<Units> listUnits() {
        return unitsMapper.listUnits();
    }
}
