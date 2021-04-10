package com.example.udong.service;

import java.util.Map;

import com.example.udong.repository.MemberRepository;
import com.example.udong.util.CommonDao.CommonDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MemberService{

    
    @Autowired
    private CommonDao dao;
        
    public Object getMember(Object dataMap){
        String sqlMapid = "Member.user";
        Object resultObject = dao.getObject(sqlMapid,dataMap);
        return resultObject;
    } 
    public Object setMember(Object dataMap){
        String sqlMapid = "Member.signup";
        Object resultObject = dao.saveObject(sqlMapid,dataMap);
        return resultObject;
    }
    public void deleteMember(Object dataMap){
        String sqlMapid = "Member.delete";
        dao.deleteObject(sqlMapid, dataMap);
    }
}