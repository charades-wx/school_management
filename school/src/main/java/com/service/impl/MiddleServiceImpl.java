package com.service.impl;

import com.bean.Middle;
import com.dao.MiddleMapper;
import com.service.MiddleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MiddleServiceImpl implements MiddleService {

    @Autowired
    private MiddleMapper mm;


    @Override
    public int deleteByPrimaryKey(Integer middleid) {
        return 0;
    }

    @Override
    public int insert(Middle record) {
        return 0;
    }

    @Override
    public int insertSelective(Middle record) {
        return 0;
    }

    @Override
    public Middle selectByPrimaryKey(Integer middleid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Middle record) {
        return 0;
    }


    @Override
    public void delroleid(int roleid) {
        mm.delroleid(roleid);
    }

    @Override
    public int add(Integer roleid, int[] menu) {
        Map map = new HashMap();
        map.put("roleid",roleid);
        map.put("menu",menu);
        return mm.add(map);
    }

    @Override
    public int updateByPrimaryKey(Middle record) {
        return 0;
    }
}
