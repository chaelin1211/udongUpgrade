<%@ page import="org.json.simple.JSONArray" %>
<%@page import="com.example.udong.util.ClubBean"%>
<%@page import="com.example.udong.udong.ClubDao"%>
<%@page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    //DB 객체 준비
    ClubDao clubdao = ClubDao.getInstance();

    //데이터 가져오기
    JSONArray jsonArray = clubdao.getClubJSON();
%>