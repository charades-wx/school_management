package com.service;

import com.bean.UserTb;

import javax.xml.registry.infomodel.User;
import java.util.List;

public interface UserTbService {

    UserTb login(UserTb u);

    UserTb update(UserTb u);

    int updatepass(UserTb u);

    List findall(int did, int mid, String tea);

    UserTb findone(int userId);

    int updateByPrimaryKeySelective(UserTb user );

    void delete(int userId);

    int insertSelective(UserTb userTb);

    List<UserTb> findalluser();
}