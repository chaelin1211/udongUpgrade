package com.example.udong.service;

import com.example.udong.repository.CategoryRepository;
import com.example.udong.util.CommonDao.CommonDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CategoryService{

    @Autowired
    private CategoryRepository repository;
    
    @Autowired
    private CommonDao dao;

    public Object getAll(Object dataMap){
        String sqlMapid = "Category.getAll";
        Object resultObject = dao.getList(sqlMapid,dataMap);
        return resultObject;
    }
}