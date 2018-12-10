package com.bean;

import java.util.List;

public class Role {
    private Integer roleid;

    private String rolename;

    private Integer rolestate;

    private List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", rolestate=" + rolestate +
                ", menus=" + menus +
                '}';
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Integer getRolestate() {
        return rolestate;
    }

    public void setRolestate(Integer rolestate) {
        this.rolestate = rolestate;
    }
}