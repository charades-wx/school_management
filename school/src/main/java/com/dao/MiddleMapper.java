package com.dao;

import com.bean.Middle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface MiddleMapper {
    int deleteByPrimaryKey(Integer middleid);

    int insert(Middle record);

    int insertSelective(Middle record);

    Middle selectByPrimaryKey(Integer middleid);

    int updateByPrimaryKeySelective(Middle record);

    int updateByPrimaryKey(Middle record);

    int add(Map map);

    void delroleid(@Param("roleid") int roleid);

}