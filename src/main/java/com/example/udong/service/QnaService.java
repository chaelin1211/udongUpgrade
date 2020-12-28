package com.example.udong.service;

import java.util.Map;
import java.util.HashMap;

import com.example.udong.repository.QnaRepository;
import com.example.udong.util.MemberDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class QnaService{

    @Autowired
    private QnaRepository repository;
    
    @Autowired
    private MemberDao dao;

    public Object getList(Object dataMap) {

		Object resultObject = new HashMap<>();
		// ((Map<String, Object>) resultObject).put("resultList", dao.getList(sqlMapId,
		// dataMap));
		((Map<String, Object>) resultObject).put("resultList", repository.findAll());

		return resultObject;
    }
    
    public Object getObject(Object dataMap){
        String sqlMapid = "Answer.read";
        Object resultObject = dao.getObject(sqlMapid,dataMap);
        return resultObject;
    }

    // public Object saveObject(Map<String, Object> dataMap) {
    //   String uniqueSequence = (String) dataMap.get("NUM");
  
    //   // if ("".equals(uniqueSequence)) {
    //   //   uniqueSequence = commonUtil.getUniqueSequence();
    //   // }
    //   dataMap.put("NUM", uniqueSequence);
  
    //   String sqlMapId = "Answer.insert";
  
    //   Integer resultKey = (Integer) dao.saveObject(sqlMapId, dataMap);
  
    //   Object resultObject = this.getObject(dataMap);
  
    //   return resultObject;
    // }

    public Object setObject(Object dataMap){
      String sqlMapid = "Answer.insert";
      Object resultObject = dao.saveObject(sqlMapid,dataMap);
      return resultObject;
  }

    // public Object updateObject(Map<String, Object> dataMap) {
    //   String sqlMapId = "Answer.update";
  
    //   Integer resultKey = (Integer) dao.saveObject(sqlMapId, dataMap);
  
    //   Object resultObject = this.getObject(dataMap);
  
    //   return resultObject;
  
    // }
  
    public Object deleteObject(Object dataMap) {
      String sqlMapId = "Answer.delete";
  
      Integer resultKey = (Integer) dao.deleteObject(sqlMapId, dataMap);
  
      Object resultObject = this.getList(dataMap);
  
      return resultObject;
    }
    
}