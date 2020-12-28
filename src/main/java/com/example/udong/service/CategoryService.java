package com.example.udong.service;

import com.example.udong.repository.CategoryRepository;
import com.example.udong.util.MemberDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CategoryService{

    @Autowired
    private CategoryRepository repository;
    
    @Autowired
    private MemberDao dao;

    public Object getMember(Object dataMap){
        String sqlMapid = "Category.user";
        Object resultObject = dao.getObject(sqlMapid,dataMap);
        return resultObject;
    }
}