package com.example.udong.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.udong.service.AreaService;
import com.example.udong.service.BoardService;
import com.example.udong.service.ClubService;
import com.example.udong.service.CommentService;
import com.example.udong.service.InterestCategoryService;
import com.example.udong.service.MemberService;
import com.example.udong.service.RecommendService;
import com.example.udong.util.MemberBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    // @Autowired
    // private MemberService memberService;
    @Autowired
    private BoardService boardService;

    @Autowired
    private ClubService clubService;

    @RequestMapping(value = "/{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
            ModelAndView modelAndView) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        Object resultList = new Object();
        // MemberBean member = new MemberBean();
        String viewName = action;

        Map<String, Object> userInform = new HashMap<String, Object>();

        if (paramMap.get("userEmail") == null)
            userInform.put("userEmail", "");
        else
            userInform.put("userEmail", paramMap.get("userEmail"));

        if ("login".equals(action) && userInform.get("userEmail") != "") {
            viewName = "/home";
        }

        // divided depending on action value
        if ("signup".equals(action)) {
            // Object interestList = interestService.getList(paramMap);
            // Object localList = areaservice.getLocal(paramMap);
            // modelAndView.addObject("interestList", interestList);
            // modelAndView.addObject("localList", localList);
            // modelAndView.addObject("resultBean", member);
            // modelAndView.addObject("idCheck", false);
        } else if ("home".equals(action) || viewName.equals("/home")) {
            Object clubList = clubService.getNewlylist();
            resultList = boardService.getPostList();
            modelAndView.addObject("clubList", clubList);
            // home으로 가려할 때
            if (paramMap.keySet().contains("submit")) {
                Object submitValue = paramMap.get("submit");
                // if (submitValue.equals("로그인")) { // 로그인 창에서 버튼을 눌렀을때
                // resultMap = (Map) service.getMember(paramMap);
                // if (resultMap.size() != 0) {
                // userInform.put("userEmail", paramMap.get("userEmail"));
                // } else {
                // viewName = "/login";
                // }
                if (submitValue.equals("로그아웃")) {
                    userInform.put("userEmail", "");
                } else if (submitValue.equals("회원가입")) {
                    // Object interestList = interestService.getList(paramMap);
                    // Object localList = areaservice.getLocal(paramMap);
                    // modelAndView.addObject("interestList", interestList);
                    // modelAndView.addObject("localList", localList);
                    // resultMap = (Map) service.getMember(paramMap);
                    // if (resultMap == null) {
                    // modelAndView.addObject("idCheck", false);
                    // service.setMember(paramMap);
                    // viewName = "/home";
                    // } else {
                    // modelAndView.addObject("idCheck", true);
                    // viewName = "/signup";
                    // }
                    // modelAndView.addObject("resultBean", paramMap);
                } else if (submitValue.equals("회원탈퇴")) {
                    // service.deleteMember(idMap);
                    // flagMap.put("flag", false);
                    // idMap.put("ID", "");
                }
            }
        } 

        modelAndView.setViewName(viewName);
        modelAndView.addObject("paramMap", paramMap);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.addObject("userInform", userInform);
        modelAndView.addObject("resultList", resultList);
        return modelAndView;
    }
}