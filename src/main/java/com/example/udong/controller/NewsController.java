package com.example.udong.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, HttpServletRequest req,
            @PathVariable String action, ModelAndView modelandView) {

        Object resultList = new Object();
        Object categoryMap = new HashMap<String, Object>();

        // get Category number - use action(03: event, 04: notice)
        paramMap.put("CATEGORY_NAME", action);
        categoryMap = categoryService.getCategoryNum(paramMap);
        int categoryNum = (int) ((Map<String, Object>) categoryMap).get("CATEGORY_NUM");
        paramMap.put("CATEGORY_NUM", categoryNum);

        // 로그인 체크
        HttpSession session = req.getSession();
        modelandView.addObject("member", common.checkMemberSession(session));

        paramMap.put("search", "");

        // 페이지 공통 로직
        // 전체 목록 불러오기
        String submitValue = (String) paramMap.get("submit");
        if (submitValue == null) {
            resultList = boardservice.getPost(paramMap);
        }
        // 검색
        else if (submitValue.equals("검색")) {
            // 검색 기능
            resultList = boardservice.getSearchPost(paramMap);
        }
        // divided depending on action value
        if ("notice".equals(action)) {
        } else if ("event".equals(action)) {
        }

        String viewName = "/news/" + action;

        modelandView.setViewName(viewName);

        modelandView.addObject("paramMap", paramMap);
        modelandView.addObject("boardList", resultList);
        return modelandView;
    }
}