package com.example.udong.service;

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

    public Object getList(Object dataMap){
        String sqlMapid = "Member.interest";
        Object resultObject = dao.getList(sqlMapid,dataMap);
        return resultObject;
    }
}