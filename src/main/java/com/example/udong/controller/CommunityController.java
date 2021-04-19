package com.example.udong.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.udong.service.BoardService;
import com.example.udong.service.CategoryService;
import com.example.udong.service.RecommendService;
import com.example.udong.util.CommentBean;
import com.example.udong.service.CommentService;

import org.apache.tomcat.util.digester.RuleSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommunityController {
    @Autowired
    private BoardService boardservice;

    @Autowired
    private RecommendService recommendservice;

    @Autowired
    private CommentService commentservice;

    @Autowired
    private CategoryService categoryService;

    // Receive Parameters from Html Using @RequestParam Map with @PathVariable
    @RequestMapping(value = "/community/{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
            ModelAndView modelandView) {

        Object resultList = new Object();
        Object categoryMap = new HashMap<String, Object>();

        // get Category number - use action(01: free, 02: qna)
        paramMap.put("CATEGORY_NAME", action);
        categoryMap = categoryService.getCategoryNum(paramMap);
        paramMap.put("CATEGORY_NUM", ((Map<String, Object>) categoryMap).get("CATEGORY_NUM"));

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

    @RequestMapping(value = "/view", method = { RequestMethod.GET })
    public ModelAndView viewActionMethod(@RequestParam Map<String, Object> paramMap, ModelAndView modelAndView) {

        Map<String, Object> resultMap = new HashMap<String, Object>();

        Map<String, Object> userInform = new HashMap<String, Object>();
        if (paramMap.get("userEmail") == null)
            userInform.put("userEmail", "");
        else
            userInform.put("userEmail", paramMap.get("userEmail"));

        paramMap.put("POST_NUM", paramMap.get("POST_NUM"));
        if (!paramMap.keySet().contains("submit")) {
            resultMap = (Map) boardservice.getPostOne(paramMap);
            resultMap.put("CATEGORY_NAME", paramMap.get("CATEGORY_NAME"));
        }

        // else {
        // Object submitValue = paramMap.get("submit");
        // if (submitValue.equals("댓글작성")) { // 댓글작성시
        // commentservice.insert(paramMap);
        // } else if (submitValue.equals("추천")) {
        // Map x = (Map) recommendservice.isRecommend(paramMap);
        // if (x == null) {
        // recommendservice.addRecommend(paramMap);
        // Integer y = recommendservice.countRecommend(paramMap);
        // paramMap.put("RECOMMEND", y);
        // boardservice.addRecommend(paramMap);
        // } else {
        // recommendservice.subRecommend(paramMap);
        // Integer y = recommendservice.countRecommend(paramMap);
        // paramMap.put("RECOMMEND", y);
        // boardservice.subRecommend(paramMap);
        // }
        // } else if (submitValue.equals("delete")) {
        // commentservice.delete(paramMap);
        // }
        // resultMap = (Map) boardservice.getPostOne(paramMap);
        // }
        // 댓글 목록 불러오기
        Object CommentList = commentservice.getList(paramMap);

        modelAndView.setViewName("view");
        modelAndView.addObject("commentList", CommentList);
        modelAndView.addObject("paramMap", paramMap);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.addObject("userInform", userInform);
        return modelAndView;
    }
}