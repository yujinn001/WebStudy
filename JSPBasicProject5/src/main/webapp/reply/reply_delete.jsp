<%@page import="com.sist.dao.ReplyDAO"%>
<%@page import="com.sist.dao.ReplyVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("no");
	String fno = request.getParameter("fno");
	
	// DAO 연동 => 댓글 삭제
     ReplyDAO dao = new ReplyDAO();
	dao.replyDeleteData(Integer.parseInt(no));
	// 화면 이동
	// 화면 => 1:    2: 맛집 상세보기   3: 
	response.sendRedirect("../include/main.jsp?mode=2&fno="+fno);
	
%>