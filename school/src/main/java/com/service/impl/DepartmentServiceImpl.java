package com.service.impl;

import com.bean.Department;
import com.dao.DepartmentMapper;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper dpm;
    @Override
    public int deleteByPrimaryKey(Integer departid) {
        return 0;
    }

    @Override
    public int insert(Department record) {
        return 0;
    }

    @Override
    public int insertSelective(Department record) {
        return 0;
    }

    @Override
    public Department selectByPrimaryKey(Integer departid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return 0;
    }

    @Override
    public List<Department> getparts() {
        return dpm.getparts();
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return 0;
    }
}
