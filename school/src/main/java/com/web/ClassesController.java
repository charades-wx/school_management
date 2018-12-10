package com.web;

import com.bean.Classes;
import com.bean.Department;
import com.bean.Major;
import com.bean.UserTb;
import com.github.pagehelper.PageInfo;
import com.service.ClassesService;
import com.service.DepartmentService;
import com.service.MajorService;
import com.service.UserTbService;
import com.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ClassesController {
    @Autowired
    private ClassesService cs;
    @Autowired
    private MajorService ms;
    @Autowired
    private DepartmentService ds;
    @Autowired
    private UserTbService ut;

    @RequestMapping("/Educational/class/deleteclass")
    public void deletecla(int classid,HttpServletResponse response) throws IOException {
        System.out.println(classid);
        int i = cs.deleteByPrimaryKey(classid);
        response.setContentType("text/html;charset=utf-8");
        if(i>0){
            response.getWriter().write("<script>alert('删除成功！');location.href='/Educational/class/getclasslist'</script>");
        }else{
            response.getWriter().write("<script>alert('删除失败！');location.href='/Educational/class/getclasslist'</script>");
        }

    }


    @RequestMapping("/Educational/class/updatecla")
    public void updatecla(Classes cla,HttpServletResponse response) throws IOException {
        int i = cs.updateByPrimaryKeySelective(cla);
        response.setContentType("text/html;charset=utf-8");
        if(i>0){
            response.getWriter().write("<script>alert('修改成功！');location.href='/Educational/class/getclasslist'</script>");
        }else{
            response.getWriter().write("<script>alert('修改失败！');location.href='/Educational/class/getclasslist'</script>");
        }

    }

    @RequestMapping("/Educational/class/updateclass")
    public String getone(int classid,HttpServletRequest request){
        Classes classes = cs.getone(classid);
        request.setAttribute("c",classes);
        return "/Educational/class/change";
    }

    @RequestMapping("/Educational/class/updateclassstate")
    public void changestate(Classes classes,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        classes.setClassstate("审核中");
        classes.setTakenum(classes.getTakenum()+1);
        int i = cs.updateByPrimaryKeySelective(classes);
        if(i>0){
            response.getWriter().write("<script>alert('提交成功！请耐心等待处理结果');location.href='/Educational/class/getclasslist'</script>");
        }else{
            response.getWriter().write("<script>alert('提交失败');location.href='/Educational/class/getclasslist'</script>");
        }
    }


    @RequestMapping("/Educational/class/daochu")
    public void daochu(HttpServletResponse response,int[] single){
        PageInfo pg = cs.getclass(null,null, 0, 0, single, null);
        List<Classes> list=pg.getList();
        ExcelUtil.headers=new String[]{"院系","班级编号","班级名称","班主任老师","人数","班级状态"};
        ExcelUtil.createhead(6);
        ExcelUtil.createother(list);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddhhmmss");
        String date= simpleDateFormat.format(new Date());
        FileOutputStream out= null;
        try {
            out = new FileOutputStream("E:\\class"+date+".xls");//加一个时间，以防文件名重复
            ExcelUtil.export(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out2=response.getWriter();
            out2.print("<script>alert('成功导出至D盘根目录');location.href='/Educational/class/getclasslist'</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/Educational/class/insertclass")
    public String insertclass(Classes cla){
        cla.setClassstate("未审核");
        cs.insert(cla);
        return "redirect:/Educational/class/getclasslist";
    }

    @RequestMapping("/Educational/student/getcla")
    @ResponseBody
    public List getcla(int did,int mid){
        List<Classes> list = cs.getcla(did,mid);
        return list;
    }

    @RequestMapping("/Educational/**/getmajorbydid")
    @ResponseBody
    public List getmajorbydid(int did){
        List list = ms.findbydid(did);
        return list;
    }
    @RequestMapping("/Educational/class/getteacher")
    @ResponseBody
    public List getteacher(int did,int mid){
        List<UserTb> list = ut.findall(did,mid,"班主任");
        return list;
    }

    @RequestMapping("/Educational/class/addclass")
    public String getparts(HttpServletRequest request){
        List<Department> list = ds.getparts();
        request.setAttribute("parts",list);
        return "/Educational/class/add";
    }
    //处理审核
    @RequestMapping("/Educational/chuli")
    public void chuli(HttpServletResponse response , Classes classes) throws IOException {
        cs.updateByPrimaryKeySelective(classes);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<script>location.href='/Educational/getclasses'</script>");
    }

    //班级详情
    @RequestMapping("/Educational/**/information")
    public String getinformation(int classid,HttpServletRequest request){
        Classes classes = cs.getinfo(classid);
        request.setAttribute("cla",classes);
        return "/Educational/class/info";
    }

    //审核--查询班级
    @RequestMapping("/Educational/getclasses")
    public String getclass( String classname, String classnum,HttpServletRequest request,
                                @RequestParam(value = "index",defaultValue = "1") int index,
                                @RequestParam(value = "size",defaultValue = "5") int size){
        PageInfo pageInfo = cs.getclass(classname,classnum,index,size,null,"审核中");
        pageInfo.setPageSize(size);
        request.setAttribute("cname",classname);
        request.setAttribute("cnum",classnum);
        request.setAttribute("p",pageInfo);
        return "/Educational/Auditing";
    }

    @RequestMapping("/Educational/class/getclasslist")
    public String getclasslist( String classname , String classnum,HttpServletRequest request,
                           @RequestParam(value = "index",defaultValue = "1") int index,
                           @RequestParam(value = "size",defaultValue = "5") int size){
        PageInfo pageInfo = cs.getclass(classname,classnum,index,size,null,null);
        request.setAttribute("cname",classname);
        request.setAttribute("cnum",classnum);
        request.setAttribute("size",size);
        request.setAttribute("p",pageInfo);
        return "/Educational/class/list";
    }
}
