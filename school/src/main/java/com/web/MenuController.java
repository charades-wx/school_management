package com.web;

import com.bean.Menu;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private MenuService ms;

    @RequestMapping("/power/menu/deletemenu")
    public void delete(int menuid,HttpServletResponse response) throws IOException {
        int i = ms.deleteByPrimaryKey(menuid);
        response.setContentType("text/html;charset=utf-8");
        if(i>0){
            response.getWriter().write("<script>alert('删除成功');location.href='/power/menu/menulist'</script>");
        }else{
            response.getWriter().write("<script>alert('删除失败');location.href='/power/menu/menulist'</script>");
        }
    }

    @RequestMapping("/power/menu/addmenu")
    public void addmenu(HttpServletResponse response,Menu menu) throws IOException {
        int i = ms.insertSelective(menu);
        response.setContentType("text/html;charset=utf-8");
        if(i>0){
            response.getWriter().write("<script>alert('添加成功');location.href='/power/menu/menulist'</script>");
        }else{
            response.getWriter().write("<script>alert('添加失败');location.href='/power/menu/menulist'</script>");
        }
    }

    @RequestMapping("/power/menu/firstmenu")
    public String getfirstmenu(HttpServletRequest request){
        List<Menu> list = ms.getfirst();
        request.setAttribute("m",list);
        return "/power/menu/add";
    }

    @RequestMapping("/power/menu/menulist")
    public String getall(@RequestParam(value="index",defaultValue = "1") int index,
                         @RequestParam(value="size",defaultValue = "5") int size,
                         HttpServletRequest request){
        PageHelper.startPage(index,size);
        List<Menu> menus = ms.getmenus();
        PageInfo pageInfo = new PageInfo(menus);
        pageInfo.setPageSize(size);
        request.setAttribute("p",pageInfo);
        return "/power/menu/list";
    }
}
