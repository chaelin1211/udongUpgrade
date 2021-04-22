package com.example.udong.service;


import java.util.HashMap;
import java.util.Map;

import com.example.udong.repository.CommentRepository;
import com.example.udong.util.CommentBean;
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
      Object resultObject = dao.getObject(sqlMapid,dataMap);
      return resultObject;
    }
    public Object getList(Object dataMap){
        String sqlMapid = "Comment.getList";
        Object resultObject = dao.getList(sqlMapid,dataMap);
        return resultObject;
    }
    public void insert(Object dataMap){
      String sqlMapid = "Comment.insert";
      dao.saveObject(sqlMapid,dataMap);
    }
    public void delete(Object dataMap){
      String sqlMapid = "Comment.delete";
      dao.deleteObject(sqlMapid,dataMap);
    }
    public void update(Object dataMap){
      String sqlMapid = "Comment.update";
      dao.updateObject(sqlMapid,dataMap);
    }
    
}