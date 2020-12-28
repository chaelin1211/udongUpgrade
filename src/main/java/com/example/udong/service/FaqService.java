package com.example.udong.service;


import java.util.HashMap;
import java.util.Map;

import com.example.udong.repository.FaqRepository;
import com.example.udong.util.MemberDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FaqService{

    @Autowired
    private FaqRepository repository;
    
    @Autowired
    private MemberDao dao;


    public Object getList(Object dataMap) {
		String sqlMapId = "Faq.list";

		Object resultObject = new HashMap<>();
		// ((Map<String, Object>) resultObject).put("resultList", dao.getList(sqlMapId,
		// dataMap));
		((Map<String, Object>) resultObject).put("resultList", repository.findAll());

		return resultObject;
    }
    
    public Object getObject(Object dataMap){
        String sqlMapid = "Faq.read";
        Object resultObject = dao.getObject(sqlMapid,dataMap);
        return resultObject;
    }
    
}