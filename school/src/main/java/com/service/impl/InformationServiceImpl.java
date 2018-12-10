package com.service.impl;

import com.bean.Information;
import com.dao.InformationMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationMapper im;

    @Override
    public int deleteByPrimaryKey(Integer informationid) {
        return 0;
    }

    @Override
    public int insert(Information record) {
        return im.insert(record);
    }

    @Override
    public int insertSelective(Information record) {
        return 0;
    }

    @Override
    public Information selectByPrimaryKey(Integer informationid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Information record) {
        return 0;
    }

    @Override
    public PageInfo selectlist(String informationname, int infoid,int index,int size) {
        PageHelper.startPage(index,size);
        Map map = new HashMap();
        map.put("iname",informationname);
        map.put("fid",infoid);
        List<Information> list = im.selectlist(map);
        PageInfo pageInfo = new PageInfo(list);

        return pageInfo;
    }

    @Override
    public int updateByPrimaryKey(Information record) {
        return 0;
    }
}
