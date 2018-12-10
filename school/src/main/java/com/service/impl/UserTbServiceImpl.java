package com.service.impl;

import com.bean.UserTb;
import com.dao.UserTbMapper;
import com.service.UserTbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserTbServiceImpl implements UserTbService {
    @Autowired()
    private UserTbMapper um;

    @Override
    public UserTb login(UserTb u) {
        UserTb u1 = um.login(u);
        if(u1!=null&&u1.getRole().getRolestate()==1&&u1.getUserPs().equals(u.getUserPs())){
            //修改登录次数
            u1.setLogincount(u1.getLogincount()+1);
            um.countadd(u1);
            return u1;
        }
        return null;
    }

    @Override
    public List<UserTb> findalluser() {
        return um.findalluser();
    }

    @Override
    public int insertSelective(UserTb userTb) {
        return um.insertSelective(userTb);
    }

    @Override
    public void delete(int userId) {
        um.delete(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserTb user) {
        return um.updateByPrimaryKeySelective(user);
    }

    @Override
    public UserTb findone(int userId) {
        return um.findone(userId);
    }

    @Override
    public List findall(int did, int mid, String tea) {
        Map map = new HashMap();
        map.put("did",did);
        map.put("mid",mid);
        map.put("tea",tea);
        return um.findall(map);
    }

    @Override
    @Transactional
    public int updatepass(UserTb u) {
        return um.updatepass(u);
    }

    @Override
    @Transactional
    public UserTb update(UserTb u) {
        int i = um.update(u);
        if(i>0){
            UserTb u1 = um.selectbyid(u);
            return u1;
        }
        return null;
    }
}
