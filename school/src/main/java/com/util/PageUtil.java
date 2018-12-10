package com.util;

import com.github.pagehelper.PageInfo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class PageUtil extends SimpleTagSupport {

    private PageInfo pageInfo;
    private String url;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void doTag() throws JspException, IOException {

        JspWriter out = this.getJspContext().getOut();
        StringBuffer str = new StringBuffer();
        str.append("<a href='"+url+"&index=1&size="+pageInfo.getPageSize()+"'>首页</a>&nbsp;");
        str.append("<a href='"+url+"&index="+(pageInfo.getPrePage()==0?pageInfo.getPageNum():pageInfo.getPrePage())+"&size="+pageInfo.getPageSize()+"'>上一页</a>&nbsp;");
        for(int i=1;i<=pageInfo.getPages();i++){
            str.append("<a href='"+url+"&index="+i+"&size="+pageInfo.getPageSize()+"'>"+i+"</a>&nbsp;&nbsp;");
        }
        str.append("<a href='"+url+"&index="+(pageInfo.getNextPage()==0?pageInfo.getPageNum():pageInfo.getNextPage())+"&size="+pageInfo.getPageSize()+"'>下一页</a>&nbsp;");
        str.append("<a href='"+url+"&index="+pageInfo.getPages()+"&size="+pageInfo.getPageSize()+"'>尾页</a>&nbsp;");
        str.append("当前页 "+pageInfo.getPageNum()+"/总页数 "+pageInfo.getPages());
        out.print(str.toString());
    }
}
