package com.example.udong.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.udong.service.AreaService;
import com.example.udong.service.ClubService;
import com.example.udong.service.InterestCategoryService;
import com.example.udong.util.ClubBean;
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
public class ClubController {
    @Autowired
    private ClubService clubService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private InterestCategoryService interestCategoryService;

    private Common common = new Common();

    // Receive Parameters from Html Using @RequestParam Map with @PathVariable
    @RequestMapping(value = "/club/{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
            ModelAndView modelandView, HttpServletRequest req) {
        Object resultList = new Object();
        Object sortList = new Object();

        // 로그인 체크
        HttpSession session = req.getSession();
        MemberBean member = common.checkMemberSession(session);
        modelandView.addObject("member", member);

        String viewName = "/club/" + action;

        // divided depending on action value
        if ("location".equals(action)) {
            // 지역 카테고리 생성을 위한 리스트
            sortList = areaService.getAll();
            resultList = clubService.getNewlylist();
            modelandView.addObject("sortList", sortList);
        } else if ("interest".equals(action)) {
            // 분야 카테고리 생성을 위한 리스트
            sortList = interestCategoryService.getAll();
            resultList = clubService.getNewlylist();
            modelandView.addObject("sortList", sortList);
        }
        // else if ("interest_search".equals(action)) {
        // // resultMap = clubService.getinterest_search(paramMap);
        // // interest up logic
        // } else if ("introduce".equals(action)) {

        // } else if ("clubBoard".equals(action)) {

        // }
        else if ("clubCreate".equals(action)) {
            sortList = areaService.getAll();
            modelandView.addObject("locationList", sortList);

            sortList = interestCategoryService.getAll();
            modelandView.addObject("interestList", sortList);
        } else if ("ranking".equals(action)) {
            resultList = clubService.getRankingList();
        } else if ("create".equals(action)) {
            ClubBean clubBean = new ClubBean();
            clubBean.setAREA_NUM(Integer.parseInt(areaService.getAreaNum(paramMap).toString()));
            clubBean.setINTEREST_NUM(Integer.parseInt(interestCategoryService.getInterestNum(paramMap).toString()));
            clubBean.setCLUB_NAME((String) paramMap.get("CLUB_NAME"));
            clubBean.setCONTENT((String) paramMap.get("CONTENT"));
            clubBean.setINTRO((String) paramMap.get("INTRO"));
            clubBean.setUSER_ID(member.getUSER_ID());
            clubBean.setPIN((String) paramMap.get("PIN"));
            try{
                clubBean = (ClubBean) clubService.insertClub(clubBean);
                Object newClub = clubService.getClub(clubBean);
                viewName = "/club/introduce";
                modelandView.addObject("club", newClub);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        modelandView.setViewName(viewName);

        modelandView.addObject("paramMap", paramMap);
        modelandView.addObject("resultList", resultList);
        return modelandView;
    }

    @RequestMapping(value = "/club/search/{action}", method = { RequestMethod.GET })
    public String clubLocationMethod(Model model, @RequestParam Map<String, Object> paramMap,
            @PathVariable String action) {
        Object resultList = new Object();

        if (action.equals("location")) {
            resultList = clubLocationList(paramMap);
        } else if (action.equals("interest")) {
            resultList = clubInterestList(paramMap);
        }

        model.addAttribute("resultList", resultList);

        return "/fragments/clubList :: #clubList";
    }

    public Object clubLocationList(Map<String, Object> paramMap) {
        Object resultList = new Object();
        // 모든 지역
        if (paramMap.get("AREA_NAME") == null || paramMap.get("AREA_NAME").equals("모두")) {
            resultList = clubService.getNewlylist();
        }
        // 특정 지역
        else {
            // 지역 번호 조회
            paramMap.put("AREA_NUM", areaService.getAreaNum(paramMap));

            // 출력 리스트
            resultList = clubService.getClubArea(paramMap);
        }
        return resultList;
    }

    public Object clubInterestList(Map<String, Object> paramMap) {
        Object resultList = new Object();
        // 모든 분야
        if (paramMap.get("INTEREST_NAME") == null || paramMap.get("INTEREST_NAME").equals("모두")) {
            resultList = clubService.getNewlylist();
        }
        // 특정 분야
        else {
            // 분야 번호 조회
            paramMap.put("INTEREST_NUM", interestCategoryService.getInterestNum(paramMap));

            // 출력 리스트
            resultList = clubService.getClubInterest(paramMap);
        }
        return resultList;
    }
}
