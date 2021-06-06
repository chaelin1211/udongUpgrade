package com.example.udong.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.udong.service.AreaService;
import com.example.udong.service.ClubService;
import com.example.udong.service.InterestCategoryService;

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

    // Receive Parameters from Html Using @RequestParam Map with @PathVariable
    @RequestMapping(value = "/club/{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
            ModelAndView modelandView) {
        Object resultList = new Object();
        Object sortList = new Object();

        Map<String, Object> userInform = new HashMap<String, Object>();

        if (paramMap.get("userEmail") == null)
            userInform.put("userEmail", "");
        else
            userInform.put("userEmail", paramMap.get("userEmail"));

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
        else if("clubCreate".equals(action)){
            sortList = areaService.getAll();
            modelandView.addObject("locationList", sortList);
            
            sortList = interestCategoryService.getAll();
            modelandView.addObject("interestList", sortList);
        }
        else if ("ranking".equals(action)) {
            resultList = clubService.getRankingList();
        }

        String viewName = "/club/" + action;

        modelandView.setViewName(viewName);

        modelandView.addObject("paramMap", paramMap);
        modelandView.addObject("resultList", resultList);
        modelandView.addObject("userInform", userInform);
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
            Map<String, Object> areaMap = new HashMap<String, Object>();
            areaMap = (Map<String, Object>) areaService.getAreaNum(paramMap);
            paramMap.put("AREA_NUM", areaMap.get("AREA_NUM").toString());

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
            Object interestMap = new HashMap<String, Object>();
            interestMap = interestCategoryService.getInterestNum(paramMap);
            paramMap.put("INTEREST_NUM", ((Map<String, Object>) interestMap).get("INTEREST_NUM").toString());

            // 출력 리스트
            resultList = clubService.getClubInterest(paramMap);
        }
        return resultList;
    }
}