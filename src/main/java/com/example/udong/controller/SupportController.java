package com.example.udong.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.udong.service.FaqService;
import com.example.udong.service.QnaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SupportController {

    @Autowired
    private FaqService faq_service;

    @Autowired
    private QnaService qna_service;

    // Receive Parameters from Html Using @RequestParam Map with @PathVariable
    @RequestMapping(value = "/support/{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
            ModelAndView modelandView) {

        Object resultMap = new HashMap<String, Object>();

        Map<String, Object> userInform = new HashMap<String, Object>();

        if (paramMap.get("userEmail") == null)
            userInform.put("userEmail", "");
        else
            userInform.put("userEmail", paramMap.get("userEmail"));

        // divided depending on action value
        if ("faq".equals(action)) {
            resultMap = faq_service.getList(paramMap);
        } else if ("ask".equals(action)) {
        } else if ("insert".equals(action)) {
            resultMap = qna_service.setObject(paramMap);
            action = "ask";
        }

        String viewName = "/support/" + action;

        modelandView.setViewName(viewName);

        modelandView.addObject("paramMap", paramMap);
        modelandView.addObject("resultMap", resultMap);
        modelandView.addObject("userInform", userInform);
        return modelandView;
    }
}