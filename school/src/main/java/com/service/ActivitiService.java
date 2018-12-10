package com.service;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

import java.io.InputStream;
import java.util.List;

public interface ActivitiService {


    List<Deployment> getdeplist();

    List<ProcessDefinition> getprolist();

    void add(InputStream inputStream, String name);

    InputStream findimage(String depid, String imagename);

    void deletedeploy(String depid);

    void qingjia(int leaveid, String userName);
}
