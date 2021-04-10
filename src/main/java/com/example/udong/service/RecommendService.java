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
  public void subRecommend(Object dataMap){
    String sqlMapid = "Recommend.deleteRecommend";
    dao.updateObject(sqlMapid, dataMap);
  }
  public void addRecommend(Object dataMap){
    String sqlMapid = "Recommend.insertRecommend";
    dao.updateObject(sqlMapid, dataMap);
  }
  public int countRecommend(Object dataMap){
    String sqlMapid = "Recommend.countRecommend";
    int size = (Integer)dao.getObject(sqlMapid, dataMap);
    return size;
  }
}