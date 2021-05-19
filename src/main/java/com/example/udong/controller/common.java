package com.example.udong.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.example.udong.util.MemberBean;

public class common {
    public static MemberBean checkMemberSession(HttpSession session) {
        HashMap map = (HashMap) session.getAttribute("member");
        return mapToBean(map);
    }

    public static MemberBean mapToBean(HashMap map) {
        if (map == null || map.get("USER_ID") == null)
            return null;
        MemberBean member = new MemberBean();
        member.setUSER_ID((String) map.get("USER_ID"));
        member.setNICKNAME((String) map.get("NICKNAME"));
        member.setAREA_NUM(Integer.parseInt(map.get("AREA_NUM").toString()));
        member.setBIRTH_MONTH(Integer.parseInt(map.get("BIRTH_MONTH").toString()));
        member.setBIRTH_DAY(Integer.parseInt(map.get("BIRTH_DAY").toString()));
        if(map.get("GRADE")!=null)
            member.setGRADE(Integer.parseInt(map.get("GRADE").toString()));
        return member;
    }
}