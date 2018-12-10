package com.service.impl;

import com.bean.Role;
import com.dao.RoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper rm;

    @Override
    public int deleteByPrimaryKey(Integer roleid) {
        return rm.deleteByPrimaryKey(roleid);
    }

    @Override
    public int insert(Role record) {
        return 0;
    }

    @Override
    public int insertSelective(Role record) {
        return 0;
    }

    @Override
    public Role selectByPrimaryKey(Integer roleid) {
        return rm.selectByPrimaryKey(roleid);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return rm.updateByPrimaryKeySelective(record);
    }

    @Override
    public void updatestate(int roleid, int rolestate) {
        Map map = new HashMap();
        map.put("roleid",roleid);
        map.put("rolestate",rolestate);
        rm.updatestate(map);
    }

    @Override
    public int addrole(Role role) {

       return rm.addrole(role);
    }

    @Override
    public PageInfo getall(int index,int size) {
        PageHelper.startPage(index,size);
        List<Role> list = rm.getall();
        PageInfo pageInfo = new PageInfo(list);

        return pageInfo;
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return 0;
    }
}
