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

import groovy.transform.ASTTest;

@Controller
public class CommunityController {
    @Autowired
    BoardService boardservice;

    // Receive Parameters from Html Using @RequestParam Map with @PathVariable
    @RequestMapping(value = "/community/{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
            ModelAndView modelandView) {

        Object resultMap = new HashMap<String, Object>();
        Map<String, Object> flagMap = new HashMap<String, Object>();
        Object resultList = new Object();

        if (paramMap.get("flag") == null)
            flagMap.put("flag", false);
        else {
            flagMap.put("flag", paramMap.get("flag"));
        }
        Map<String, Object> idMap = new HashMap<String, Object>();

        if (paramMap.get("userID") == null)
            idMap.put("ID", "");
        else
            idMap.put("ID", paramMap.get("userID"));

        if(paramMap.get("search")==null)
            paramMap.put("search", "");

        // divided depending on action value
        if ("free".equals(action)) {
            // free logic
            paramMap.put("CATEGORY", "free");
            if (!paramMap.keySet().contains("submit")) {
                // 전체 목록 불러오기
                resultList = boardservice.getPost(paramMap);
            } else {
                Object submitValue = paramMap.get("submit");
                if (submitValue.equals("검색")) {
                    // 검색 기능
                    paramMap.put("CATEGORY", "free");
                    resultList = boardservice.getSearchPost(paramMap);
                }else if(submitValue.equals("삭제")) {
                    // 삭제 기능
                    paramMap.put("CATEGORY", "free");
                    boardservice.deletePost(paramMap);
                    resultList = boardservice.getPost(paramMap);
                }else if(submitValue.equals("글작성")){
                    boardservice.insertPost(paramMap);
                    resultList = boardservice.getPost(paramMap);
                }
            }
        } else if ("qna".equals(action)) {
            // qna logic
            paramMap.put("CATEGORY", "qna");
            if (!paramMap.keySet().contains("submit")) {
                // 전체 목록 불러오기
                resultList = boardservice.getPost(paramMap);
            } else {
                Object submitValue = paramMap.get("submit");
                if (submitValue.equals("검색")) {
                    // 검색 기능
                    paramMap.put("CATEGORY", "qna");
                    resultList = boardservice.getSearchPost(paramMap);
                }else if(submitValue.equals("글작성")){
                    boardservice.insertPost(paramMap);
                    resultList = boardservice.getPost(paramMap);
                }
            }
        }

        String viewName = "/community/" + action;

        modelandView.setViewName(viewName);

        modelandView.addObject("resultMap", resultMap);
        modelandView.addObject("paramMap", paramMap);
        modelandView.addObject("resultList", resultList);
        modelandView.addObject("idMap", idMap);
        modelandView.addObject("flag", flagMap);
        return modelandView;
    }
}