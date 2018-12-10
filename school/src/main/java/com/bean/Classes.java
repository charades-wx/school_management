package com.bean;

import lombok.Data;

import java.util.Date;


public class Classes {
    private Integer classid;

    private String classnum;

    private Integer deptid;

    private Integer majorid;

    private Major major;

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    private Integer takenum;

    private String classname;

    private Date classbegin;

    private Date classend;

    @Override
    public String toString() {
        return "Classes{" +
                "classid=" + classid +
                ", classnum='" + classnum + '\'' +
                ", deptid=" + deptid +
                ", majorid=" + majorid +
                ", major=" + major +
                ", takenum=" + takenum +
                ", classname='" + classname + '\'' +
                ", classbegin=" + classbegin +
                ", classend=" + classend +
                ", classcontent='" + classcontent + '\'' +
                ", classqq='" + classqq + '\'' +
                ", tagline='" + tagline + '\'' +
                ", classteacher='" + classteacher + '\'' +
                ", peoplecount=" + peoplecount +
                ", classstate='" + classstate + '\'' +
                ", department=" + department +
                '}';
    }

    public Integer getTakenum() {
        return takenum;
    }

    public void setTakenum(Integer takenum) {
        this.takenum = takenum;
    }

    public Classes(Integer classid, String classnum, Integer deptid, Integer majorid, Integer takenum, String classname, Date classbegin, Date classend, String classcontent, String classqq, String tagline, String classteacher, Integer peoplecount, String classstate, Department department) {
        this.classid = classid;
        this.classnum = classnum;
        this.deptid = deptid;
        this.majorid = majorid;
        this.takenum = takenum;
        this.classname = classname;
        this.classbegin = classbegin;
        this.classend = classend;
        this.classcontent = classcontent;
        this.classqq = classqq;
        this.tagline = tagline;
        this.classteacher = classteacher;
        this.peoplecount = peoplecount;
        this.classstate = classstate;
        this.department = department;
    }

    public Classes() {
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Date getClassbegin() {
        return classbegin;
    }

    public void setClassbegin(Date classbegin) {
        this.classbegin = classbegin;
    }

    public Date getClassend() {
        return classend;
    }

    public void setClassend(Date classend) {
        this.classend = classend;
    }

    public String getClasscontent() {
        return classcontent;
    }

    public void setClasscontent(String classcontent) {
        this.classcontent = classcontent;
    }

    public String getClassqq() {
        return classqq;
    }

    public void setClassqq(String classqq) {
        this.classqq = classqq;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getClassteacher() {
        return classteacher;
    }

    public void setClassteacher(String classteacher) {
        this.classteacher = classteacher;
    }

    public Integer getPeoplecount() {
        return peoplecount;
    }

    public void setPeoplecount(Integer peoplecount) {
        this.peoplecount = peoplecount;
    }

    public String getClassstate() {
        return classstate;
    }

    public void setClassstate(String classstate) {
        this.classstate = classstate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    private String classcontent;

    private String classqq;

    private String tagline;

    private String classteacher;

    private Integer peoplecount;

    private String classstate;

    private Department department;
}