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
import org.springframework.ui.Model;
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
    private MemberService memberService;

    @Autowired
    private AreaService areaService;

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

        String email = userInform.get("userEmail").toString();
        if ("login".equals(action) && userInform.get("userEmail") != "") {
            String submitValue = (String) paramMap.get("submit");
            if (submitValue != null && submitValue.equals("회원가입")) {
                MemberBean memberBean = new MemberBean();
                memberBean.setEMAIL(paramMap.get("userEmail").toString());
                memberBean.setBIRTH_MONTH(Integer.parseInt(paramMap.get("birthMonth").toString()));
                memberBean.setBIRTH_DAY(Integer.parseInt(paramMap.get("birthDay").toString()));
                // 지역 번호 조회
                Map<String, Object> areaMap = (Map<String, Object>) areaService.getAreaNum(paramMap);
                memberBean.setAREA_NUM(Integer.parseInt(areaMap.get("AREA_NUM").toString()));
                memberService.setMember(memberBean);
                viewName = "/home";
            }
            else if (isUser(email)) {
                viewName = "/home";
            } else {
                userInform.put("userEmail", "");
                resultMap.put("email", paramMap.get("userEmail"));
                resultMap.put("birthDay", paramMap.get("birthDay"));
                resultMap.put("birthMonth", paramMap.get("birthMonth"));
                viewName = "/signup";
            }
        }

        // divided depending on action value
        if ("home".equals(action) || viewName.equals("/home")) {
            Object clubList = clubService.getNewlylist();
            resultList = boardService.getPostList();
            modelAndView.addObject("clubList", clubList);
            // home으로 가려할 때
            if (paramMap.keySet().contains("submit")) {
                Object submitValue = paramMap.get("submit");
                if (submitValue.equals("로그아웃")) {
                    userInform.put("userEmail", "");
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

    // 회원 체크
    @RequestMapping(value = "/user/signIn", method = { RequestMethod.GET })
    public Boolean checkUserMethod(@RequestParam Map<String, Object> paramMap) {
        return isUser(paramMap.get("EMAIL").toString());
    }

    public Boolean isUser(String email) {
        MemberBean memberBean = new MemberBean();
        memberBean.setEMAIL(email);
        Object member = memberService.getMember(memberBean);
        if (member != null) {
            return true;
        }
        return false;
    }

    // 추천 추가/삭제
    @RequestMapping(value = "/arealist", method = { RequestMethod.GET })
    public String areaListMethod(Model model, @RequestParam Map<String, Object> paramMap) {
        Object sortList = areaService.getAll();
        model.addAttribute("sortList", sortList);
        return "/signup :: #sortList";
    }
}