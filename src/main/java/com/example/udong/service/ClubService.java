package com.example.udong.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.udong.repository.ClubRepository;
import com.example.udong.util.CommonDao.CommonDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

@Service
public class ClubService {

    @Autowired
    private ClubRepository repository;

    @Autowired
    private CommonDao dao;

    public Object getClubArea(Object dataMap){
        String sqlMapid = "Club.getClubArea";
        Object resultObject = dao.getList(sqlMapid,dataMap);
        return resultObject;
    }

    public Object getNewlylist() {
        String sqlMapid = "Club.getNewlyList";
        Object resultObject = dao.getAll(sqlMapid);
        return resultObject;
    }

    public Object getlocation_search(Object dataMap){
        String sqlMapid = "Club.location_search";
        Object resultObject = dao.getList(sqlMapid,dataMap);
        ((ArrayList<HashMap<String, Object>>)resultObject).add((HashMap<String, Object>) dataMap);
        return resultObject;
    }
    
    public Object getClubInterest(Object dataMap){
        String sqlMapid = "Club.getClubInterest";
        Object resultObject = dao.getList(sqlMapid,dataMap);
        return resultObject;
    }
    
    public Object getRankingList(){
        String sqlMapid = "Club.getRankingList";
        Object resultObject = dao.getAll(sqlMapid);
        return resultObject;
    }
}