package com.dao;

import com.bean.Classes;
import com.bean.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ClassesMapper {
    int deleteByPrimaryKey(Integer classid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

    List<Classes> getclass(Map map);

    int changestate(Map map);

    Classes getinfo(@Param("classid") int classid);

    List<Classes> getcla(Map map);

    Classes getone(int classid);
}