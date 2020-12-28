package com.example.udong.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.udong.util.HomeDao;
import com.example.udong.repository.ClubRepository;
import com.example.udong.util.RankingDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class HomeService {

    @Autowired
    private HomeDao dao;

    @Autowired
    private ClubRepository club_repository;

    public Object get(Object dataMap) {

        String sqlMapid = "home.fetchbyinterest";

        // if paramNull sqlMapid changes ( same as just visit home not involving param)
        if (ObjectUtils.isEmpty(dataMap)) {
            sqlMapid = "home.fetchbyinterest_ifparamNull";
        }

        Object resultObject = dao.getList(sqlMapid, dataMap);

        // select top3 records classifying by interest
        ArrayList<HashMap<String, Object>> passed_resultObject = new ArrayList<HashMap<String, Object>>();

        int recordsnum = ((ArrayList<HashMap<String, Object>>) resultObject).size();

        if (recordsnum > 3) {
            for (int i = 0; i < 3; i++) {
                passed_resultObject.add((HashMap<String, Object>) ((Map) ((ArrayList<Object>) resultObject).get(i)));
            }
        } else {
            for (int i = 0; i < recordsnum; i++) {
                // ((Map) ((ArrayList<Object>) resultObject).get(i)).put("RANK", i + 1);
                passed_resultObject.add((HashMap<String, Object>) ((Map) ((ArrayList<Object>) resultObject).get(i)));
            }
        }

        return passed_resultObject;
    }

    public Object getNewlylist(Object dataMap) {

        String sqlMapid = "fetchbyinterest_ifparamNull";
        Object resultObject = dao.getList(sqlMapid, dataMap);

        int recordsnum = ((ArrayList<HashMap<String, Object>>) resultObject).size();

        return resultObject;
    }

    public Object get_pickList(Object dataMap) {
        String sqlMapId = "home.editor_pick";

        Object resultObject = new HashMap<>();
        // ((Map<String, Object>) resultObject).put("resultList", dao.getList(sqlMapId,
        // dataMap));
        ((Map<String, Object>) resultObject).put("resultList", club_repository.findAll());

        return resultObject;
    }
}