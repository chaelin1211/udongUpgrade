package com.example.udong.service;

import java.util.Map;

import com.example.udong.repository.InterestCategoryRepository;
import com.example.udong.util.CommonDao.CommonDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class InterestCategoryService{

    @Autowired
    private InterestCategoryRepository repository;
    
    @Autowired
    private CommonDao dao;

    public Object getAll(){
        String sqlMapid = "Interest.getAll";
        Object resultObject = dao.getAll(sqlMapid);
        return resultObject;
    }

    public Object getInterestNum(Object dataMap){
        String sqlMapid = "Interest.getInterestNum";
        Map<String, Object> resultObject = (Map<String, Object>)dao.getObject(sqlMapid,dataMap);
        return resultObject.get("INTEREST_NUM");
    }
}