package com.example.udong.service;

import java.util.Map;

import com.example.udong.repository.MemberRepository;
import com.example.udong.util.MemberBean;
import com.example.udong.util.MemberDao;
// import com.example.udong.util.CommonDao.CommonDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MemberService{

    
    @Autowired
    private MemberDao dao;
        
    public MemberBean getMember(MemberBean dataMap){
        String sqlMapid = "Member.getMember";
        MemberBean resultObject = dao.getObject(sqlMapid,dataMap);
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