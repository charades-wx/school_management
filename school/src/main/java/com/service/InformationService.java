package com.service;

import com.bean.Information;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InformationService {
    int deleteByPrimaryKey(Integer informationid);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer informationid);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);

    PageInfo selectlist(String informationname, int infoid,int index,int size);

}