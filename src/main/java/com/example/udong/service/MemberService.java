package com.example.udong.service;

import java.util.Map;

import com.example.udong.repository.MemberRepository;
import com.example.udong.util.MemberDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MemberService{

    
    @Autowired
    private MemberDao dao;
        
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