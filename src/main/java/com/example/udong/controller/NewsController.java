package com.example.udong.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.udong.service.BoardService;
import com.example.udong.service.CategoryService;
import com.example.udong.service.MemberService;

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

    @Autowired
    MemberService memberService;
    
    @Autowired
    CategoryService categoryService;

    // Receive Parameters from Html Using @RequestParam Map with @PathVariable
    @RequestMapping(value = "/news/{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
            ModelAndView modelandView) {

        Object resultList = new Object();
        Object categoryMap = new HashMap<String, Object>();
        
        // get Category number - use action(03: event, 04: notice)
        paramMap.put("CATEGORY_NAME", action);
        categoryMap = categoryService.getCategoryNum(paramMap);
        int categoryNum = (int) ((Map<String, Object>) categoryMap).get("CATEGORY_NUM");
        paramMap.put("CATEGORY_NUM", categoryNum);

        // set userInform
        Map<String, Object> userInform = new HashMap<String, Object>();

        if (paramMap.get("userEmail") == "" || paramMap.get("userEmail") == null)
            userInform.put("userEmail", "");
        else{
            userInform.put("userEmail", paramMap.get("userEmail"));
            userInform.put("userGrade", ((Map<String, Object>) memberService.getMember(userInform)).get("GRADE"));
        }
        paramMap.put("search", "");

        
        // 페이지 공통 로직
        // 전체 목록 불러오기
        if (!paramMap.keySet().contains("submit")) {
            resultList = boardservice.getPost(paramMap);
        } 
        // 검색
        else {
            Object submitValue = paramMap.get("submit");
            if (submitValue.equals("검색")) {
                // 검색 기능
                resultList = boardservice.getSearchPost(paramMap);
            }
        }
        // divided depending on action value
        if ("notice".equals(action)) {
        } else if ("event".equals(action)) {
        }

        String viewName = "/news/" + action;

        modelandView.setViewName(viewName);

        modelandView.addObject("paramMap", paramMap);
        modelandView.addObject("resultList", resultList);
        modelandView.addObject("userInform", userInform);
        return modelandView;
    }
}