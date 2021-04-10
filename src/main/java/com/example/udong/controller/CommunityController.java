package com.example.udong.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.udong.service.BoardService;
import com.example.udong.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommunityController {
    @Autowired
    BoardService boardservice;

    @Autowired
    CategoryService categoryService;

    // Receive Parameters from Html Using @RequestParam Map with @PathVariable
    @RequestMapping(value = "/community/{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
            ModelAndView modelandView) {

        Object resultList = new Object();
        Object categoryMap = new HashMap<String, Object>();

        // get Category number - use action(01: free, 02: qna)
        paramMap.put("CATEGORY_NAME", action);
        categoryMap = categoryService.getCategoryNum(paramMap);
        int categoryNum = (int) ((Map<String, Object>) categoryMap).get("CATEGORY_NUM");
        paramMap.put("CATEGORY_NUM", categoryNum);

        // set userInform
        Map<String, Object> userInform = new HashMap<String, Object>();

        if (paramMap.get("userEmail") == null)
            userInform.put("userEmail", "");
        else
            userInform.put("userEmail", paramMap.get("userEmail"));

        if (paramMap.get("search") == null)
            paramMap.put("search", "");

        // 페이지 공통 로직
        // 전체 목록 불러오기
        if (!paramMap.keySet().contains("submit")) {
            resultList = boardservice.getPost(paramMap);
        } else {
            Object submitValue = paramMap.get("submit");
            // 검색 기능
            if (submitValue.equals("검색")) {
                resultList = boardservice.getSearchPost(paramMap);
            }
            // 삭제 기능
            else if (submitValue.equals("삭제")) {
                boardservice.deletePost(paramMap);
                resultList = boardservice.getPost(paramMap);
            }
            // 글 작성
            else if (submitValue.equals("글작성")) {
                boardservice.insertPost(paramMap);
                resultList = boardservice.getPost(paramMap);
            }
        }
        // divided depending on action value
        if ("free".equals(action)) {
        } else if ("qna".equals(action)) {
        }

        String viewName = "/community/" + action;

        modelandView.setViewName(viewName);
        modelandView.addObject("paramMap", paramMap);
        modelandView.addObject("resultList", resultList);
        modelandView.addObject("userInform", userInform);
        return modelandView;
    }
}