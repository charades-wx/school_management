package com.service;

import com.bean.Middle;


public interface MiddleService {
    int deleteByPrimaryKey(Integer middleid);

    int insert(Middle record);

    int insertSelective(Middle record);

    Middle selectByPrimaryKey(Integer middleid);

    int updateByPrimaryKeySelective(Middle record);

    int updateByPrimaryKey(Middle record);

    int add(Integer roleid, int[] menu);

    void delroleid(int roleid);

}