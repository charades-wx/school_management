package com.service;

import com.bean.Classes;
import com.bean.Department;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.List;


public interface ClassesService {

    int deleteByPrimaryKey(Integer classid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

    PageInfo getclass(String classname,String classnum,int index,int size,int[] ids,String state);

    Classes getinfo(int classid);

    List<Classes> getcla(int did, int mid);

    Classes getone(int classid);
}