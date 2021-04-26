package com.example.udong.service;

import com.example.udong.util.CommonDao.CommonDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RecommendService {


  @Autowired
  private CommonDao dao;

  public Object isRecommend(Object dataMap) {
    String sqlMapid = "Recommend.isRecommend";
    Object resultObject = dao.getObject(sqlMapid, dataMap);
    return resultObject;
  }
  public Object deleteRecommend(Object dataMap){
    String sqlMapid = "Recommend.deleteRecommend";
    Object resultObject = dao.deleteObject(sqlMapid, dataMap);
    return resultObject;
  }
  public Object addRecommend(Object dataMap){
    String sqlMapid = "Recommend.insertRecommend";
    Object resultObject = dao.updateObject(sqlMapid, dataMap);
    return resultObject;
  }
  public int countRecommend(Object dataMap){
    String sqlMapid = "Recommend.countRecommend";
    int size = (Integer)dao.getObject(sqlMapid, dataMap);
    return size;
  }
}