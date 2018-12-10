package com.service.impl;

import com.bean.Menu;
import com.bean.UserTb;
import com.dao.MenuMapper;
import com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper mm;


    public UserTb selectmenu(UserTb user){
        List<Menu> rolemenus = new ArrayList<Menu>();
        List<Menu> list = mm.selectmenu(user.getRoleId());
        for (Menu menu : list) {

            if(menu.getUpmenuid()==-1){//一级菜单
                List<Menu> menus2 = new ArrayList<Menu>();//一级菜单下的二级菜单集合
                for (Menu menu2 : list) {//再次循环遍历，找出该一级菜单下的二级菜单
                    if(menu.getMenuid()==menu2.getUpmenuid()){
                        menus2.add(menu2);
                    }
                }
                menu.setSeconde(menus2);//将该一级菜单下的二级菜单集合赋给Seconde属性
                rolemenus.add(menu);//将该一级菜单放入集合
            }
        }
        user.getRole().setMenus(rolemenus);
        return user;
    }


    @Override
    public int deleteByPrimaryKey(Integer menuid) {
        return mm.deleteByPrimaryKey(menuid);
    }

    @Override
    public int insert(Menu record) {
        return 0;
    }

    @Override
    public int insertSelective(Menu record) {
        return mm.insertSelective(record);
    }

    @Override
    public Menu selectByPrimaryKey(Integer menuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return 0;
    }

    @Override
    public List<Menu> getfirst() {
        return mm.getfirst();
    }

    @Override
    public List<Menu> getmenus() {
        return mm.getall();
    }

    @Override
    public List<Menu> getmenu(int roleid) {
        List<Menu> list = mm.selectmenu(roleid);
        List<Menu> rolemenus = new ArrayList<Menu>();
        for (Menu menu : list) {
            if(menu.getUpmenuid()==-1){
                List<Menu> menus2 = new ArrayList<Menu>();
                for (Menu menu2 : list) {
                    if(menu.getMenuid()==menu2.getUpmenuid()){
                        menus2.add(menu2);
                    }
                }
                menu.setSeconde(menus2);
                rolemenus.add(menu);
            }
        }
        return rolemenus;
    }

    @Override
    public List<Menu> getall() {
        List<Menu> menus = new ArrayList<Menu>();
        List<Menu> list = mm.getall();
        for (Menu menu : list) {
            if(menu.getUpmenuid()==-1){
                List<Menu> menus2 = new ArrayList<Menu>();
                for (Menu menu2 : list) {
                    if(menu2.getUpmenuid()==menu.getMenuid()){
                        menus2.add(menu2);
                    }
                }
                menu.setSeconde(menus2);
                menus.add(menu);
            }
        }
        return menus;
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return 0;
    }
}
