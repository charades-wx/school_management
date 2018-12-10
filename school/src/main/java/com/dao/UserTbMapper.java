package com.dao;

import com.bean.UserTb;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserTbMapper {

    UserTb login(UserTb u);

    void countadd(UserTb u1);

    int update(UserTb u);

    UserTb selectbyid(UserTb u);

    int updatepass(UserTb u);

    List findall(Map map);

    UserTb findone( int userId);

    int updateByPrimaryKeySelective(UserTb user);

    void delete( int userId);

    int insertSelective(UserTb userTb);

    List<UserTb> findalluser();
}