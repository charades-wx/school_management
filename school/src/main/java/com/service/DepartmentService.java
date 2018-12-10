package com.service;

import com.bean.Department;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
    int deleteByPrimaryKey(Integer departid);

    List<Department> getparts();

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}