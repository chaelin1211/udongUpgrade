package com.example.udong.service;

import com.example.udong.repository.ClubMemberRepository;
import com.example.udong.util.CommonDao.CommonDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClubMemberService{

    @Autowired
    private CommonDao dao;

    public Object getMember(Object dataMap){
        String sqlMapid = "ClubMember.user";
        Object resultObject = dao.getObject(sqlMapid,dataMap);
        return resultObject;
    }
}