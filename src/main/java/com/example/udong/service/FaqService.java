package com.example.udong.service;

import java.util.HashMap;
import java.util.Map;

import com.example.udong.repository.FaqRepository;
import com.example.udong.util.CommonDao.CommonDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FaqService {

  @Autowired
  private FaqRepository repository;

  @Autowired
  private CommonDao commonDao;

  public Object getList(Object dataMap) {
    String sqlMapId = "Faq.getAll";

    Object resultObject = commonDao.getList(sqlMapId, dataMap);
    // Object resultObject = new HashMap<>();
    // ((Map<String, Object>) resultObject).put("resultList", dao.getList(sqlMapId,
    // dataMap));
    // ((Map<String, Object>) resultObject).put("resultList", repository.findAll());

    return resultObject;
  }

  // public Object getObject(Object dataMap) {
  //   String sqlMapid = "Faq.get";
  //   Object resultObject = commonDao.getObject(sqlMapid, dataMap);
  //   return resultObject;
  // }

}