package com.example.udong.service;

import com.example.udong.repository.AreaRepository;
import com.example.udong.util.CommonDao.CommonDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AreaService{

    @Autowired
    private AreaRepository repository;
    
    @Autowired
    private CommonDao dao;

    public Object getLocal(Object dataMap){
        String sqlMapid = "Area.local";
        Object resultObject = dao.getList(sqlMapid,dataMap);
        return resultObject;
    }
}