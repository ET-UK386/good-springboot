package com.zb.mapper;

import com.zb.pojo.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SortMapper {
    //查询
    List<Sort> listSort();

}
