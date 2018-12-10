package com.web;

import com.bean.Role;
import com.bean.UserTb;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.MenuService;
import com.service.RoleService;
import com.service.UserTbService;
import com.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"user","logintime"})
public class UserController {

    @Autowired
    private UserTbService us;

    @Autowired
    private RoleService rs;
    @Autowired
    private MenuService ms;

    @RequestMapping("/text")
    public void test(String name,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("哑谜");
    }

    @RequestMapping("/power/user/adduse")
    public void adduser(UserTb userTb,HttpServletResponse response) throws IOException {
        userTb.setStudentId(0);
        userTb.setLogincount(0);
        userTb.setRegdate(new Date());
        int i = us.insertSelective(userTb);
        response.setContentType("text/html;charset=utf-8");
        if(i>0){
            response.getWriter().write("<script>alert('添加成功');location.href='/power/user/getall'</script>");
        }else{
            response.getWriter().write("<script>alert('添加失败');location.href='/power/user/getall'</script>");
        }
    }

    @RequestMapping("/power/user/addpage")
    public String addpage(HttpServletRequest request){
        PageInfo pageInfo = rs.getall(0, 0);
        List list = pageInfo.getList();
        request.setAttribute("role",list);
        return "/power/user/add";
    }

    @RequestMapping("/power/user/editpage")
    public String edit(int userId,HttpServletRequest request){
        UserTb user = us.findone(userId);
        PageInfo<Role> p = rs.getall(0, 0);
        request.setAttribute("us",user);
        request.setAttribute("p",p);
        return "/power/user/edit";
    }

    @RequestMapping("/power/user/delete")
    public String delete(int userId){
        us.delete(userId);

        return "redirect:/power/user/getall";
    }

    @RequestMapping("/power/user/change")
    public void update(UserTb user,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        System.out.println(user.toString());
        int i = us.updateByPrimaryKeySelective(user);
        if(i>0){
            response.getWriter().write("<script>alert('修改成功');location.href='/power/user/getall'</script>");
        }else{
            response.getWriter().write("<script>alert('修改失败');location.href='/power/user/getall'</script>");
        }
    }

    @RequestMapping("/power/user/infopage")
    public String info(int userId,HttpServletRequest request){
        UserTb user = us.findone(userId);
        request.setAttribute("u",user);
        return "/power/user/info";
    }


    @RequestMapping("/power/user/getall")
    public String getall(@RequestParam(value = "index",defaultValue = "1") int index,
                         @RequestParam(value = "size",defaultValue = "5") int size,
                         HttpServletRequest request){
        PageHelper.startPage(index,size);
        List<UserTb> list = us.findalluser();
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setPageSize(size);
        request.setAttribute("p",pageInfo);

        return "/power/user/list";
    }

    //修改密码
    @RequestMapping("/user/updatepassword")
    public void updatepass(UserTb u,SessionStatus status,HttpServletResponse response) throws IOException {
        int i = us.updatepass(u);
        response.setContentType("text/html;charset=utf-8");
        if(i>0){
            status.setComplete();
            response.getWriter().write("<script>alert('修改成功');top.location.href='/login.jsp'</script>");
        }
    }
    //修改user基本信息
    @RequestMapping("user/updateuser")
    public void updateuser(UserTb u2,ModelMap map,HttpServletResponse response) throws IOException {
        UserTb u1 = us.update(u2);
        response.setContentType("text/html;charset=utf-8 ");
        if(u1!=null){
            map.put("user",u1);
            response.getWriter().write("<script>alert('修改成功');top.location.href='/index.jsp'</script>");
        }else{
            response.getWriter().write("<script>alert('修改失败');top.location.href='MyUser.jsp'</script>");
        }
    }

    //退出
    @RequestMapping("/ex")
    public void login(HttpServletResponse response, SessionStatus status) throws IOException {
        status.setComplete();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<script>location.href='login.jsp'</script>");
    }
    //登录
    @RequestMapping("/login")
    public void login(UserTb u, HttpServletResponse response,
                      String DropExpiration, ModelMap map,String yanzheng) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String code = ImageUtil.getCode();
        if(code.equalsIgnoreCase(yanzheng)){
            UserTb userTb = us.login(u);
            UserTb u1 = ms.selectmenu(userTb);
            if(u1!=null){
                map.put("user",u1);
                Cookie cookie1 = new Cookie("name",u.getUserName());
                Cookie cookie2 = new Cookie("pass",u.getUserPs());
                if(DropExpiration.equals("Day")){
                    cookie1.setMaxAge(60*60*24);
                    cookie2.setMaxAge(60*60*24);
                }else if(DropExpiration.equals("Month")){
                    cookie1.setMaxAge(60*60*24*30);
                    cookie2.setMaxAge(60*60*24*30);
                }else if (DropExpiration.equals("Year")){
                    cookie1.setMaxAge(60*60*24*365);
                    cookie2.setMaxAge(60*60*24*365);
                }else if(DropExpiration.equals("None")){
                    cookie1.setMaxAge(0);
                    cookie2.setMaxAge(0);
                }
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                Date date = new Date();
                map.put("logintime",date);
                response.getWriter().write("<script>alert('登录成功');location.href='index.jsp'</script>");

            }else{
                response.getWriter().write("<script>alert('登录失败！');location.href='login.jsp'</script>");
            }
        }else{
            response.getWriter().write("<script>alert('验证码错误！');location.href='login.jsp'</script>");
        }

    }
}
