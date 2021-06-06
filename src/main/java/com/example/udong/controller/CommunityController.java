package com.example.udong.controller;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.udong.controller.common;

import com.example.udong.service.BoardService;
import com.example.udong.service.CategoryService;
import com.example.udong.service.RecommendService;
import com.example.udong.util.BoardBean;
import com.example.udong.util.CommentBean;
import com.example.udong.util.MemberBean;
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
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, HttpServletRequest req,
            @PathVariable String action, ModelAndView modelandView) {

        Object boardList = new Object();
        Object categoryMap = new HashMap<String, Object>();

        // get Category number - use action(01: free, 02: qna)
        paramMap.put("CATEGORY_NAME", action);
        categoryMap = categoryService.getCategoryNum(paramMap);
        paramMap.put("CATEGORY_NUM", ((Map<String, Object>) categoryMap).get("CATEGORY_NUM"));

        // set userInform
        // Map<String, Object> userInform = new HashMap<String, Object>();

        // if (paramMap.get("userEmail") == null)
        // userInform.put("userEmail", "");
        // else
        // userInform.put("userEmail", paramMap.get("userEmail"));

        // if (paramMap.get("search") == null)
        // paramMap.put("search", "");

        HttpSession session = req.getSession();
        MemberBean memberBean = common.checkMemberSession(session);
        modelandView.addObject("member", memberBean);

        if (!paramMap.keySet().contains("submit")) {
            // 페이지 공통 로직
            // 전체 목록 불러오기
            boardList = boardService.getPost(paramMap);
        } else {
            Object submitValue = paramMap.get("submit");
            // 검색 기능
            if (submitValue.equals("검색")) {
                boardList = boardService.getSearchPost(paramMap);
            }
            // 삭제 기능
            else if (submitValue.equals("삭제")) {
                boardService.deletePost(paramMap);
                boardList = boardService.getPost(paramMap);
            }
            // 글 작성
            else if (submitValue.equals("글작성")) {
                BoardBean boardBean = new BoardBean();
                boardBean.setUSER_ID(memberBean.getUSER_ID());
                boardBean.setTITLE(paramMap.get("TITLE").toString());
                boardBean.setCONTENT(paramMap.get("CONTENT").toString());
                boardBean.setCATEGORY_NUM(Integer.parseInt(paramMap.get("CATEGORY_NUM").toString()));
                boardService.insertPost(boardBean);
                boardList = boardService.getPost(paramMap);
            }
        }
        // divided depending on action value
        if ("free".equals(action)) {
        } else if ("qna".equals(action)) {
        }

        String viewName = "/community/" + action;

        modelandView.setViewName(viewName);
        modelandView.addObject("paramMap", paramMap);
        modelandView.addObject("boardList", boardList);
        // modelandView.addObject("userInform", userInform);
        return modelandView;
    }

    // 댓글 추가/삭제/수정
    @RequestMapping(value = "/view/{action}", method = { RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
    public String viewDeleteMethod(Model model, @PathVariable String action, HttpServletRequest req,
            @RequestParam Map<String, Object> paramMap) {
        // 로그인 체크
        HttpSession session = req.getSession();
        MemberBean member = common.checkMemberSession(session);
        model.addAttribute("member", member);
        Map<String, Object> resultMap = new HashMap<String, Object>();

        CommentBean commentBean = new CommentBean();
        commentBean.setPOST_NUM(Integer.parseInt(paramMap.get("POST_NUM").toString()));

        // String email = ( ).getEMAIL();
        model.addAttribute("member", session.getAttribute("member"));

        if (action.equals("delete")) {
            // DB 댓글 삭제
            commentBean.setCO_NUM(Integer.parseInt(paramMap.get("CO_NUM").toString()));
            commentService.delete(commentBean);
        } else if (action.equals("update")) {
            // DB 댓글 수정
            commentBean.setCO_NUM(Integer.parseInt(paramMap.get("CO_NUM").toString()));
            commentBean.setCONTENT(paramMap.get("CONTENT").toString());
            commentService.update(commentBean);
        } else if (action.equals("create")) {
            // DB 댓글 추가
            // result.setEMAIL(email);
            commentBean.setUSER_ID(member.getUSER_ID());
            commentBean.setCONTENT(paramMap.get("CONTENT").toString());
            commentService.insert(commentBean);
        }

        // 댓글 리스트 추가
        model.addAttribute("commentList", commentService.getList(commentBean));

        // 화면 일반화를 위한 정보 전달
        resultMap.put("CATEGORY_NAME", paramMap.get("CATEGORY_NAME"));
        model.addAttribute("resultMap", resultMap);
        return "/view :: #commentTable";
    }

    // view 페이지 controller
    @RequestMapping(value = "/view", method = { RequestMethod.POST })
    public ModelAndView viewActionMethod(@RequestParam Map<String, Object> paramMap, HttpServletRequest req,
            ModelAndView modelAndView) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        // 로그인 체크
        HttpSession session = req.getSession();
        MemberBean member = common.checkMemberSession(session);
        modelAndView.addObject("member", member);

        if(paramMap.get("submit")!=null && paramMap.get("submit").equals("수정")){
            // 게시글 수정 후, 화면으로 이동
            boardService.updatePost(paramMap);
        }

        resultMap = (Map) boardService.getPostOne(paramMap);
        if (paramMap.get("CATEGORY_NAME") == null) {
            // get Category Name
            resultMap.put("CATEGORY_NAME",
                    ((Map<String, Object>) categoryService.getCategoryName(paramMap)).get("CATEGORY_NAME"));
        } else {
            resultMap.put("CATEGORY_NAME", paramMap.get("CATEGORY_NAME"));
        }

        resultMap.put("isRecommend", 0);
        if (member != null) {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("USER_ID", member.getUSER_ID());
            param.put("POST_NUM", paramMap.get("POST_NUM"));
            resultMap.put("isRecommend", recommendService.isRecommend(param));
        }

        // 댓글 목록 불러오기
        Object CommentList = commentService.getList(paramMap);

        // 추천 수 받아오기
        resultMap.put("recommend", getNumberOfRecommend(paramMap));

        modelAndView.setViewName("view");
        modelAndView.addObject("commentList", CommentList);
        modelAndView.addObject("paramMap", paramMap);
        modelAndView.addObject("resultMap", resultMap);
        return modelAndView;
    }

    // 추천 추가/삭제
    @RequestMapping(value = "/view/recommend/{action}", method = { RequestMethod.PUT, RequestMethod.DELETE })
    public String recommendUpdateMethod(Model model, @PathVariable String action, HttpServletRequest req,
            @RequestParam Map<String, Object> paramMap) {
        // 로그인 체크
        HttpSession session = req.getSession();
        MemberBean member = common.checkMemberSession(session);
        model.addAttribute("member", member);
        Map<String, Object> resultMap = new HashMap<String, Object>();

        if (member != null) {
            RecommendBean recommendBean = new RecommendBean();
            recommendBean.setUSER_ID(member.getUSER_ID());
            recommendBean.setPOST_NUM(Integer.parseInt(paramMap.get("POST_NUM").toString()));

            // 추천 추가
            if (action.equals("PUT")) {
                Integer resultRow = (Integer) recommendService.addRecommend(recommendBean);
                if (resultRow == 1) {
                    int nowRecommend = Integer.parseInt(paramMap.get("RECOMMEND").toString());
                    resultMap.put("recommend", nowRecommend + 1);
                    resultMap.put("isRecommend", 1);
                }
            }
            // 추천 삭제
            else if (action.equals("DELETE")) {
                Integer resultRow = (Integer) recommendService.deleteRecommend(recommendBean);
                if (resultRow == 1) {
                    int nowRecommend = Integer.parseInt(paramMap.get("RECOMMEND").toString());
                    resultMap.put("recommend", nowRecommend - 1);
                    resultMap.put("isRecommend", 0);
                }
            }
        }

        // 화면 일반화를 위한 정보 전달
        resultMap.put("POST_NUM", paramMap.get("POST_NUM"));
        model.addAttribute("resultMap", resultMap);
        return "/view :: #recommendField";
    }

    // 게시글 수정
    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView postUpdateMethod(@RequestParam Map<String, Object> paramMap, ModelAndView modelAndView) {
        Map<String, Object> userInform = new HashMap<String, Object>();

        if (paramMap.get("userEmail") == null)
            userInform.put("userEmail", "");
        else
            userInform.put("userEmail", paramMap.get("userEmail"));

        modelAndView.addObject("paramMap", paramMap);
        modelAndView.addObject("userInform", userInform);
        return modelAndView;
    }

    private int getNumberOfRecommend(Map<String, Object> paramMap) {
        Integer num = recommendService.countRecommend(paramMap);
        if (num == null) {
            return 0;
        }
        return num;
    }
}