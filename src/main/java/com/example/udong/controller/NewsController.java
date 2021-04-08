package com.example.udong.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.udong.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController {
    @Autowired
    BoardService boardservice;

    // Receive Parameters from Html Using @RequestParam Map with @PathVariable
    @RequestMapping(value = "/news/{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
            ModelAndView modelandView) {

        Object resultMap = new HashMap<String, Object>();
        Object resultList = new Object();

        Map<String, Object> userInform = new HashMap<String, Object>();

        if (paramMap.get("userEmail") == null)
            userInform.put("userEmail", "");
        else
            userInform.put("userEmail", paramMap.get("userEmail"));

        paramMap.put("search", "");
        // divided depending on action value
        if ("notice".equals(action)) {
            // notice logic
            if (!paramMap.keySet().contains("submit")) {
                // 전체 목록 불러오기
                Map<String, Object> category = new HashMap<String, Object>();
                category.put("CATEGORY", "notice");
                resultList = boardservice.getPost(category);
            } else {
                Object submitValue = paramMap.get("submit");
                if (submitValue.equals("검색")) {
                    // 검색 기능
                    paramMap.put("CATEGORY", "notice");
                    resultList = boardservice.getSearchPost(paramMap);
                }
            }
        } else if ("event".equals(action)) {
            // event logic
            if (!paramMap.keySet().contains("submit")) {
                // 전체 목록 불러오기
                Map<String, Object> category = new HashMap<String, Object>();
                category.put("CATEGORY", "event");
                resultList = boardservice.getPost(category);
            } else {
                Object submitValue = paramMap.get("submit");
                if (submitValue.equals("검색")) {
                    // 검색 기능
                    paramMap.put("CATEGORY", "event");
                    resultList = boardservice.getSearchPost(paramMap);
                }
            }
        }

        String viewName = "/news/" + action;

        modelandView.setViewName(viewName);

        modelandView.addObject("paramMap", paramMap);
        modelandView.addObject("resultMap", resultMap);
        modelandView.addObject("resultList", resultList);
        modelandView.addObject("userInform", userInform);
        return modelandView;
    }
}