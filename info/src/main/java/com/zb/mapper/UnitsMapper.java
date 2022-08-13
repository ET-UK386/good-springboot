package com.zb.mapper;

import com.zb.pojo.Units;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UnitsMapper {
    //查询
    List<Units> listUnits();
}
