package com.service;

import com.bean.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleService {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    PageInfo getall(int index,int size);

    int addrole(Role role);

    void updatestate(int roleid, int rolestate);
}