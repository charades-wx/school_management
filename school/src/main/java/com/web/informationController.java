package com.web;

import com.bean.Information;
import com.github.pagehelper.PageInfo;
import com.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class informationController {

    @Autowired
    private InformationService is;

    @RequestMapping("/book/addfile")
    public void addfile(Information info, HttpServletRequest request,
                          MultipartFile myfile, HttpServletResponse response) throws IOException {
        String path = request.getRealPath("upload");
        info.setDate(new Date());
        info.setFiletype(path+"/"+myfile.getOriginalFilename());
        int i = is.insert(info);
        response.setContentType("text/html;charset=utf-8");
        if(i>0){
            myfile.transferTo(new File(path+"/"+myfile.getOriginalFilename()));
            response.getWriter().write("<script>alert('上传成功');location.href='/book/getziliaolist'</script>");
        }else{
            response.getWriter().write("<script>alert('上传失败');location.href='/book/add.jsp'</script>");
        }


        info.setDate(new Date());

    }


    @RequestMapping("/book/getziliaolist")
    public String getall(String informationname,
                         @RequestParam(name = "typeid",defaultValue = "-1")int typeid,
                         @RequestParam(name = "index",defaultValue = "1")int index,
                         @RequestParam(name="size",defaultValue = "5") int size,
                         HttpServletRequest request){
        PageInfo pageInfo = is.selectlist(informationname,typeid,index,size);
        pageInfo.setPageSize(size);
        request.setAttribute("p",pageInfo);
        request.setAttribute("infoname",informationname);
        request.setAttribute("itype",typeid);
        return "/book/list-ziliao";
    }
}
