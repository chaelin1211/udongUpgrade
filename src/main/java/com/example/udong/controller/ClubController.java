package com.example.udong.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.udong.service.ClubService;
import com.example.udong.service.RankingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClubController {

    @Autowired
    private RankingService service;
    @Autowired
    private ClubService service2;

    // Receive Parameters from Html Using @RequestParam Map with @PathVariable
    @RequestMapping(value = "/club/{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
            ModelAndView modelandView) {

        Object resultMap = new HashMap<String, Object>();

        Map<String, Object> userInform = new HashMap<String, Object>();

        if (paramMap.get("userEmail") == null)
            userInform.put("userEmail", "");
        else
            userInform.put("userEmail", paramMap.get("userEmail"));

        // divided depending on action value
        if ("location".equals(action)) {
            if (paramMap.get("AREA_NAME") == null) {
                paramMap.put("AREA_NAME", "%");
            }
            if (paramMap.get("AREA_NAME").equals("모두")) {
                paramMap.replace("AREA_NAME", "%");
            }
            resultMap = service2.getlocation(paramMap);
        } else if ("interest".equals(action)) {
            if (paramMap.get("INTEREST") == null) {
                paramMap.put("INTEREST", "%");
            }
            if (paramMap.get("INTEREST").equals("모두")) {
                paramMap.replace("INTEREST", "%");
            }
            resultMap = service2.getinterest(paramMap);
            // interest up logic
        } else if ("interest_search".equals(action)) {
            resultMap = service2.getinterest_search(paramMap);
            // interest up logic
        } else if ("introduce".equals(action)) {

        } else if ("clubBoard".equals(action)) {

        } else if ("ranking".equals(action)) {
            resultMap = service.get(paramMap);
        }

        String viewName = "/club/" + action;

        modelandView.setViewName(viewName);

        modelandView.addObject("paramMap", paramMap);
        modelandView.addObject("resultMap", resultMap);
        modelandView.addObject("userInform", userInform);
        return modelandView;
    }
}