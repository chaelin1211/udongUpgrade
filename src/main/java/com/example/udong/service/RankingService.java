package com.example.udong.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.udong.util.RankingDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingService {

    @Autowired
    private RankingDao dao;

    public Object get(Object dataMap) {
        String sqlMapid = "ranking.fetch";
        Object resultObject = dao.getList(sqlMapid, dataMap);

        // Append Rank num
        ArrayList<HashMap<String, Object>> resultObject02 = new ArrayList<HashMap<String, Object>>();

        int recordsnum = ((ArrayList<HashMap<String, Object>>) resultObject).size();

        if (recordsnum > 10) {
            for (int i = 0; i < 10; i++) {
                resultObject02.add((HashMap<String, Object>) ((Map) ((ArrayList<Object>) resultObject).get(i)));
                resultObject02.get(i).put("RANK", i + 1);
            }
        } else {
            for (int i = 0; i < recordsnum; i++) {
                // ((Map) ((ArrayList<Object>) resultObject).get(i)).put("RANK", i + 1);
                resultObject02.add((HashMap<String, Object>) ((Map) ((ArrayList<Object>) resultObject).get(i)));
                resultObject02.get(i).put("RANK", i + 1);
            }
        }
        return resultObject02;
    }

}