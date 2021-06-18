package com.example.udong.service;

import java.util.Map;

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
    public Object getAll(){
        String sqlMapid = "Area.getAll";
        Object resultObject = dao.getAll(sqlMapid);
        return resultObject;
    }

    public Object getAreaNum(Object dataMap){
        String sqlMapid = "Area.getAreaNum";
        Map<String, Object> resultObject = (Map<String, Object>) dao.getObject(sqlMapid,dataMap);
        return resultObject.get("AREA_NUM");
    }
}