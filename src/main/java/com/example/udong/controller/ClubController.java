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
        Map<String, Object> flagMap = new HashMap<String, Object>();

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

        // divided depending on action value
        if ("location".equals(action)) {
            if(paramMap.get("AREA_NAME")==null){
                paramMap.put("AREA_NAME", "%");
            }
            if(paramMap.get("AREA_NAME").equals("모두")){
                paramMap.replace("AREA_NAME", "%");
            }
            resultMap = service2.getlocation(paramMap);
            // location logic
        //} else if ("location_search".equals(action)) {
           // resultMap = service2.getlocation_search(paramMap);
            // interest up logic
        } else if ("interest".equals(action)) {
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
        modelandView.addObject("idMap", idMap);
        modelandView.addObject("flag", flagMap);
        return modelandView;
    }
}