package com.service.impl;

import com.bean.Student;
import com.dao.StudentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper sm;

    @Override
    public int deleteByPrimaryKey(Integer studentid) {
        return sm.deleteByPrimaryKey(studentid);
    }

    @Override
    public int insert(Student record) {
        return sm.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return sm.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer studentid) {
        return sm.selectByPrimaryKey(studentid);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return sm.updateByPrimaryKeySelective(record);
    }

    @Override
    public Student getone(int studentid) {
        return sm.getone(studentid);
    }

    @Override
    public PageInfo selectstudent(Student stu, int index, int size) {
        PageHelper.startPage(index,size);
        List<Student> list = sm.selectstudent(stu);
        PageInfo pageInfo = new PageInfo(list);

        return pageInfo;
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return sm.updateByPrimaryKey(record);
    }
}
