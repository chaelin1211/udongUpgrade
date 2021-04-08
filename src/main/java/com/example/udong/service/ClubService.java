package com.example.udong.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.udong.repository.ClubRepository;
import com.example.udong.util.ClubDao;
import com.example.udong.util.MemberDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClubService {

    @Autowired
    private ClubRepository repository;

    @Autowired
    private ClubDao dao;

    public Object getlocation(Object dataMap){
        String sqlMapid = "Club.location";
        Object resultObject = dao.getList(sqlMapid,dataMap);
        return resultObject;
    }

    public Object getNewlylist(Object dataMap) {
        String sqlMapid = "Club.getNewlyList";
        Object resultObject = dao.getList(sqlMapid, dataMap);
        return resultObject;
    }

    public Object getlocation_search(Object dataMap){
        String sqlMapid = "Club.location_search";
        Object resultObject = dao.getList(sqlMapid,dataMap);
        ((ArrayList<HashMap<String, Object>>)resultObject).add((HashMap<String, Object>) dataMap);
        return resultObject;
    }
    
    public Object getinterest(Object dataMap){
        String sqlMapid = "Club.interest";
        Object resultObject = dao.getList(sqlMapid,dataMap);
        return resultObject;
    }

    public Object getinterest_search(Object dataMap){
        String sqlMapid = "Club.interest_search";
        Object resultObject = dao.getList(sqlMapid,dataMap);
        return resultObject;
    }
}