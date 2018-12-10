package com.web;

import com.bean.Menu;
import com.bean.Role;
import com.github.pagehelper.PageInfo;
import com.service.MenuService;
import com.service.MiddleService;
import com.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService rs;
    @Autowired
    private MenuService ms;
    @Autowired
    private MiddleService mis;

    @RequestMapping("/power/role/update")
    public void update(Role role,int[] menu,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        int i = rs.updateByPrimaryKeySelective(role);
        mis.delroleid(role.getRoleid());
        int k = mis.add(role.getRoleid(),menu);
        if(i*k>0){
            response.getWriter().write("<script>alert('修改成功！');location.href='/power/role/getallrole'</script>");
        }   else{
            response.getWriter().write("<script>alert('添加失败！');location.href='/power/role/getallrole'</script>");
        }
    }

    @RequestMapping("/power/role/upstate")
    public String upstate(int roleid,int rolestate){
        rs.updatestate(roleid,rolestate);
        return "redirect:/power/role/getallrole";
    }

    @RequestMapping("/power/role/updateinfo")
    public String updatepage(int roleid,HttpServletRequest request){
        Role role = rs.selectByPrimaryKey(roleid);
        List<Menu> rolemenus = ms.getmenu(roleid);
        role.setMenus(rolemenus);
        List<Menu> list = ms.getall();

        request.setAttribute("menus",list);
        request.setAttribute("role",role);
        return "/power/role/edit";
    }

    @RequestMapping("/power/role/roleinfo")
    public String info(int roleid ,HttpServletRequest request){
        Role role = rs.selectByPrimaryKey(roleid);
        List<Menu> rolemenus = ms.getmenu(roleid);
        role.setMenus(rolemenus);

        request.setAttribute("role",role);

        return "/power/role/info";
    }

    @RequestMapping("/power/role/delete")
    public String del(int roleid){
        rs.deleteByPrimaryKey(roleid);
        mis.delroleid(roleid);
        return "redirect:/power/role/getallrole";
    }

    @RequestMapping("/power/role/addrole")
    public void addrole(HttpServletResponse response,int[] menu,Role role) throws IOException {
        int i = rs.addrole(role);
        response.setContentType("text/html;charset=utf-8");
        if(i>0){
            int k = mis.add(role.getRoleid(),menu);
            if(k>0){
                response.getWriter().write("<script>alert('添加成功！');location.href='/power/role/getallrole'</script>");
            }else{
                rs.deleteByPrimaryKey(role.getRoleid());
                response.getWriter().write("<script>alert('添加失败！');location.href='/power/role/getallrole'</script>");
            }
        }else{
            response.getWriter().write("<script>alert('添加失败！');location.href='/power/role/getallrole'</script>");
        }
    }

    @RequestMapping("/power/role/getallmenu")
    public String getmenus(HttpServletRequest request){

        List<Menu> list = ms.getall();

        request.setAttribute("menus",list);

        return "/power/role/add";
    }


    @RequestMapping("/power/role/getallrole")
    public String getall(HttpServletRequest request,
                         @RequestParam(value="index", defaultValue = "1") int index,
                         @RequestParam(value = "size",defaultValue = "5") int size){
        PageInfo pageInfo = rs.getall(index,size);
        pageInfo.setPageSize(size);
        request.setAttribute("p",pageInfo);
        return "/power/role/list";
    }
}
