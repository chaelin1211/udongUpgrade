package com.example.udong.service;


import java.util.HashMap;
import java.util.Map;

import com.example.udong.repository.CommentRepository;
import com.example.udong.util.CommonDao.CommonDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CommentService{

    @Autowired
    private CommentRepository repository;
    
    @Autowired
    private CommonDao dao;
    
    public Object getComment(Object dataMap){
        String sqlMapid = "Comment.getComment";
        Object resultObject = dao.getList(sqlMapid,dataMap);
        return resultObject;
    }
    public void insertComment(Object dataMap){
      String sqlMapid = "Comment.insertComment";
      dao.getList(sqlMapid,dataMap);
    }
    public void deleteComment(Object dataMap){
      String sqlMapid = "Comment.deleteComment";
      dao.getList(sqlMapid,dataMap);
    }
    
}