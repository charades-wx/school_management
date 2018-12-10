package com.service;

import com.bean.Menu;
import com.bean.UserTb;

import java.util.List;

public interface MenuService {
    int deleteByPrimaryKey(Integer menuid);

    int insert(Menu record);

    int insertSelective(Menu record);

    UserTb selectmenu(UserTb user);

    Menu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getall();

    List<Menu> getmenu(int roleid);

    List<Menu> getmenus();

    List<Menu> getfirst();
}