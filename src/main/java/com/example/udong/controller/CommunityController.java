package com.example.udong.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.udong.service.BoardService;
import com.example.udong.service.CategoryService;
import com.example.udong.service.RecommendService;
import com.example.udong.util.BoardBean;
import com.example.udong.util.CommentBean;
import com.example.udong.util.RecommendBean;
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
    private BoardService boardService;

    @Autowired
    private RecommendService recommendService;

    @Autowired
    private CommentService commentService;

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

        if (!paramMap.keySet().contains("submit")) {
            // 페이지 공통 로직
            // 전체 목록 불러오기
            resultList = boardService.getPost(paramMap);
        } else {
            Object submitValue = paramMap.get("submit");
            // 검색 기능
            if (submitValue.equals("검색")) {
                resultList = boardService.getSearchPost(paramMap);
            }
            // 삭제 기능
            else if (submitValue.equals("삭제")) {
                boardService.deletePost(paramMap);
                resultList = boardService.getPost(paramMap);
            }
            // 글 작성
            else if (submitValue.equals("글작성")) {
                boardService.insertPost(paramMap);
                resultList = boardService.getPost(paramMap);
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

    // 댓글 추가/삭제/수정
    @RequestMapping(value = "/view/{action}", method = { RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
    public String viewDeleteMethod(Model model, @PathVariable String action,
            @RequestParam Map<String, Object> paramMap) {

        CommentBean result = new CommentBean();
        result.setPOST_NUM(Integer.parseInt(paramMap.get("POST_NUM").toString()));

        if (action.equals("delete")) {
            // DB 댓글 삭제
            result.setCO_NUM(Integer.parseInt(paramMap.get("CO_NUM").toString()));
            commentService.delete(result);
        } else if (action.equals("update")) {
            // DB 댓글 수정
            result.setCO_NUM(Integer.parseInt(paramMap.get("CO_NUM").toString()));
            result.setCONTENT(paramMap.get("CONTENT").toString());
            commentService.update(result);
        } else if (action.equals("create")) {
            // DB 댓글 추가
            result.setEMAIL(paramMap.get("EMAIL").toString());
            result.setCONTENT(paramMap.get("CONTENT").toString());
            commentService.insert(result);
        }

        // 댓글 리스트 추가
        model.addAttribute("commentList", commentService.getList(result));

        // 수정&삭제 버튼 게시를 위한 유저 정보 전달
        Map<String, Object> userInform = new HashMap<String, Object>();
        userInform.put("userEmail", paramMap.get("EMAIL"));
        model.addAttribute("userInform", userInform);

        // 화면 일반화를 위한 정보 전달
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("CATEGORY_NAME", paramMap.get("CATEGORY_NAME"));
        model.addAttribute("resultMap", resultMap);
        return "/view :: #commentTable";
    }

    // view 페이지 controller
    @RequestMapping(value = "/view", method = { RequestMethod.POST })
    public ModelAndView viewActionMethod(@RequestParam Map<String, Object> paramMap, ModelAndView modelAndView) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> userInform = new HashMap<String, Object>();

        if (paramMap.get("userEmail") == null)
            userInform.put("userEmail", "");
        else {
            userInform.put("userEmail", paramMap.get("userEmail"));
            paramMap.put("EMAIL", paramMap.get("userEmail"));
        }
        resultMap = (Map) boardService.getPostOne(paramMap);
        if (paramMap.get("CATEGORY_NAME") == null) {
            // get Category Name
            resultMap.put("CATEGORY_NAME",
                    ((Map<String, Object>) categoryService.getCategoryName(paramMap)).get("CATEGORY_NAME"));
        } else {
            resultMap.put("CATEGORY_NAME", paramMap.get("CATEGORY_NAME"));
        }

        if (paramMap.get("EMAIL") != null) {
            resultMap.put("isRecommend", recommendService.isRecommend(paramMap));
        }

        // 댓글 목록 불러오기
        Object CommentList = commentService.getList(paramMap);

        // 추천 수 받아오기
        resultMap.put("recommend", getNumberOfRecommend(paramMap));

        modelAndView.setViewName("view");
        modelAndView.addObject("commentList", CommentList);
        modelAndView.addObject("paramMap", paramMap);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.addObject("userInform", userInform);
        return modelAndView;
    }

    // 추천 추가/삭제
    @RequestMapping(value = "/view/recommend/{action}", method = { RequestMethod.PUT, RequestMethod.DELETE })
    public String recommendUpdateMethod(Model model, @PathVariable String action,
            @RequestParam Map<String, Object> paramMap) {

        RecommendBean result = new RecommendBean();
        result.setEMAIL(paramMap.get("EMAIL").toString());
        result.setPOST_NUM(Integer.parseInt(paramMap.get("POST_NUM").toString()));

        Map<String, Object> resultMap = new HashMap<String, Object>();
        // 추천 추가
        if (action.equals("PUT")) {
            Integer resultRow = (Integer) recommendService.addRecommend(result);
            if (resultRow == 1) {
                int nowRecommend = Integer.parseInt(paramMap.get("RECOMMEND").toString());
                resultMap.put("recommend", nowRecommend + 1);
                resultMap.put("isRecommend", 1);
            }
        }
        // 추천 삭제
        else if (action.equals("DELETE")) {
            Integer resultRow = (Integer) recommendService.deleteRecommend(result);
            if (resultRow == 1) {
                int nowRecommend = Integer.parseInt(paramMap.get("RECOMMEND").toString());
                resultMap.put("recommend", nowRecommend - 1);
                resultMap.put("isRecommend", 0);
            }
        }

        // 수정&삭제 버튼 게시를 위한 유저 정보 전달
        Map<String, Object> userInform = new HashMap<String, Object>();
        userInform.put("userEmail", paramMap.get("EMAIL"));
        model.addAttribute("userInform", userInform);

        // 화면 일반화를 위한 정보 전달
        resultMap.put("POST_NUM", paramMap.get("POST_NUM"));
        model.addAttribute("resultMap", resultMap);
        return "/view :: #recommendField";
    }

    private int getNumberOfRecommend(Map<String, Object> paramMap) {
        Integer num = recommendService.countRecommend(paramMap);
        if (num == null) {
            return 0;
        }
        return num;
    }
}