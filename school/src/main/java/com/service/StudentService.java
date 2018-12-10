package com.service;

import com.bean.Student;
import com.github.pagehelper.PageInfo;

public interface StudentService {
    int deleteByPrimaryKey(Integer studentid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    PageInfo selectstudent(Student stu, int index, int size);

    Student getone(int studentid);
}