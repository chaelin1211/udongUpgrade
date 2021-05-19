package com.example.udong.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView loginMethod(@RequestParam Map<String, Object> paramMap, ModelAndView modelAndView,
            HttpServletRequest req) {
        String viewName = "/login";
        modelAndView.addObject("paramMap", paramMap);
        MemberBean memberBean = (MemberBean) memberService.getMember(paramMap);
        if (memberBean != null) {
            // 네이버 로그인 성공 후, 기존 회원은 홈화면으로
            setHomePage(modelAndView);
            HttpSession session = req.getSession();
            session.setAttribute("member", memberBean);
            modelAndView.addObject("member", memberBean);
            viewName = "/home";
        } else {
            if (paramMap.get("userId") != null) {
                // 네이버 로그인 성공 후, 회원가입 화면으로 이동
                Map<String, Object> resultMap = new HashMap<String, Object>();
                resultMap.put("userId", paramMap.get("userId"));
                resultMap.put("birthDay", paramMap.get("birthDay"));
                resultMap.put("birthMonth", paramMap.get("birthMonth"));
                modelAndView.addObject("resultMap", resultMap);
                viewName = "/signup";
            }
        }
        // 최초 로그인 화면으로 이동 포함
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    public void setHomePage(ModelAndView modelAndView) {
        Object clubList = clubService.getNewlylist();
        Object boardList = boardService.getPostList();
        modelAndView.addObject("clubList", clubList);
        modelAndView.addObject("boardList", boardList);
    }

    @RequestMapping(value = "/{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, @PathVariable String action,
            ModelAndView modelAndView, HttpServletRequest req) {
        String viewName = action;

        // 로그인 체크
        HttpSession session = req.getSession();
        modelAndView.addObject("member", common.checkMemberSession(session));

        // divided depending on action value
        if ("home".equals(action)) {
            setHomePage(modelAndView);
            String submitValue = (String) paramMap.get("submit");
            // home으로 가려할 때
            if (submitValue != null) {
                if (submitValue.equals("로그아웃")) {
                    session.invalidate();
                    modelAndView.addObject("member", null);
                } else if (submitValue.equals("회원가입")) {
                    // 회원가입 버튼 클릭
                    MemberBean memberBean = new MemberBean();
                    memberBean.setUSER_ID(paramMap.get("userId").toString());
                    memberBean.setNICKNAME(paramMap.get("nickname").toString());
                    memberBean.setBIRTH_MONTH(Integer.parseInt(paramMap.get("birthMonth").toString()));
                    memberBean.setBIRTH_DAY(Integer.parseInt(paramMap.get("birthDay").toString()));
                    // 지역 번호 조회
                    Map<String, Object> areaMap = (Map<String, Object>) areaService.getAreaNum(paramMap);
                    memberBean.setAREA_NUM(Integer.parseInt(areaMap.get("AREA_NUM").toString()));
                    memberService.setMember(memberBean);

                    // 세션 설정
                    Object member = memberService.getMember(memberBean);
                    if (member != null) {
                        session.setAttribute("member", member);
                        modelAndView.addObject("member", member);
                    } else {
                        session.setAttribute("member", null);
                    }
                }else if(submitValue.equals("회원탈퇴")){
                    MemberBean memberBean = common.checkMemberSession(session);
                    memberService.deleteMember(memberBean);
                    session.invalidate();
                    modelAndView.addObject("member", null);
                }
            }
        }

        modelAndView.setViewName(viewName);
        modelAndView.addObject("paramMap", paramMap);
        return modelAndView;
    }

    // 회원 체크
    @RequestMapping(value = "/user/signIn", method = { RequestMethod.GET })
    public String checkUserMethod(Model model, @RequestParam Map<String, Object> paramMap) {
        String userId = paramMap.get("userId").toString();
        MemberBean memberBean = new MemberBean();
        memberBean.setUSER_ID(userId);
        Object member = memberService.getMember(memberBean);
        model.addAttribute("member", member);
        return "/callback :: #userInform";
    }

    public boolean isUser(String userId) {
        MemberBean memberBean = new MemberBean();
        memberBean.setUSER_ID(userId);
        Object member = memberService.getMember(memberBean);
        if (member != null) {
            return true;
        }
        return false;
    }

    // 지역 분류 리스트 받아오기
    @RequestMapping(value = "/arealist", method = { RequestMethod.GET })
    public String areaListMethod(Model model, @RequestParam Map<String, Object> paramMap) {
        Object sortList = areaService.getAll();
        model.addAttribute("sortList", sortList);
        return "/signup :: #sortList";
    }
}