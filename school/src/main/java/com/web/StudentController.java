package com.web;

import com.bean.Classes;
import com.bean.Department;
import com.bean.Major;
import com.bean.Student;
import com.github.pagehelper.PageInfo;
import com.service.ClassesService;
import com.service.DepartmentService;
import com.service.MajorService;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService ss;
    @Autowired
    private DepartmentService ds;
    @Autowired
    private MajorService ms;
    @Autowired
    private ClassesService cs;

    @RequestMapping("/Educational/student/updatestudent")
    public void update(Student stu,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        int i = ss.updateByPrimaryKeySelective(stu);
        if(i>0){
            response.getWriter().write("<script>alert('修改成功');location.href='/Educational/student/selectstudent'</script>");
        }else{
            response.getWriter().write("<script>alert('修改失败');location.href='/Educational/student/selectstudent'</script>");
        }
    }

    @RequestMapping("/Educational/student/tuixue")
    public String delete(int studentid){
        ss.deleteByPrimaryKey(studentid);
        return "redirect:/Educational/student/selectstudent";
    }

    @RequestMapping("/Educational/student/infopage")
    public String infopage(int studentid, ModelMap map){
        Student stu = ss.getone(studentid);
        map.put("s",stu);
        return "/Educational/student/info";
    }

    @RequestMapping("/Educational/student/changepage")
    public String changepage(int studentid, ModelMap map){
        Student stu = ss.getone(studentid);
        List<Department> parts = ds.getparts();
        List<Classes> classes = cs.getcla(stu.getDeptid(), stu.getMajorid());
        List<Major> majors = ms.findbydid(stu.getDeptid());
        map.put("des",parts);
        map.put("stu",stu);
        map.put("mas",majors);
        map.put("clas",classes);
        return "/Educational/student/edit";
    }

    //添加学生
    @RequestMapping("/Educational/student/insertstu")
    public void insertstu(HttpServletResponse response,Student stu) throws IOException {
        Date date = new Date();
        stu.setRegdate(date);
        int i = ss.insertSelective(stu);
        response.setContentType("text/html;charset=utf-8");
        if(i>0){
            response.getWriter().write("<script>alert('添加成功');location.href='/Educational/student/selectstudent'</script>");
        }else{
            response.getWriter().write("<script>alert('添加失败');location.href='/Educational/student/addstu'</script>");
        }

    }

    @RequestMapping("/Educational/student/addstu")
    public String getparts(HttpServletRequest request){
        List<Department> list = ds.getparts();
        request.setAttribute("parts",list);
        return "/Educational/student/add";
    }


    @RequestMapping("/Educational/student/selectstudent")
    public String selectstudent(Student stu, @RequestParam(name="index",defaultValue = "1") int index,
                                @RequestParam(name="size",defaultValue = "5")int size, HttpServletRequest request){
        PageInfo pageInfo = ss.selectstudent(stu,index,size);
        pageInfo.setPageSize(size);
        request.setAttribute("p",pageInfo);
        request.setAttribute("stu",stu);
        request.setAttribute("index",index);
        return "/Educational/student/list";
    }

}
