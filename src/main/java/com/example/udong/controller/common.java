package com.example.udong.controller;

import javax.servlet.http.HttpSession;

import com.example.udong.util.MemberBean;

public class Common {
    public MemberBean checkMemberSession(HttpSession session) {
        return (MemberBean) session.getAttribute("member");
    }
}