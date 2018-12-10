package com.service.impl;

import com.bean.Classes;
import com.dao.ClassesMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper cm;

    @Override
    public int deleteByPrimaryKey(Integer classid) {
        return cm.deleteByPrimaryKey(classid);
    }

    @Override
    public Classes getone(int classid) {
        return cm.getone(classid);
    }

    @Override
    public List<Classes> getcla(int did, int mid) {
        Map map = new HashMap();
        map.put("did",did);
        map.put("mid",mid);

        return cm.getcla(map);
    }

    @Override
    public int insert(Classes record) {
        return cm.insert(record);
    }

    @Override
    public int insertSelective(Classes record) {
        return 0;
    }

    @Override
    public Classes getinfo(int classid) {
        return cm.getinfo(classid);
    }

    @Override
    public Classes selectByPrimaryKey(Integer classid) {
        return cm.selectByPrimaryKey(classid);
    }

    @Override
    public int updateByPrimaryKeySelective(Classes record) {
        return cm.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classes record) {
        return 0;
    }

    @Override
    public PageInfo getclass(String classname,String classnum,int index,int size,int[] ids,String state) {
        //封装模糊查条件
        Map map=new HashMap();
        map.put("cname",classname);
        map.put("cnum",classnum);
        map.put("ids",ids);
        map.put("state",state);
        PageHelper.startPage(index,size);
        List<Classes> list = cm.getclass(map);
        PageInfo p = new PageInfo(list);
        return p;
    }
}
