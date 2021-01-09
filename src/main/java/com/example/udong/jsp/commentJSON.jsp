<%@ page import="org.json.simple.JSONArray" %>
<%@page import="com.example.udong.util.CommentBean"%>
<%@page import="com.example.udong.udong.CommentDao"%>
<%@page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>

<%  
    String postNumber = (String)request.getSession().getAttribute("POSTNUM");
    //DB 객체 준비
    CommentDao commentDao = commentDao.getInstance();

    //데이터 가져오기
    JSONArray jsonArray = commentDao.getListJSON(postNumber);
%>