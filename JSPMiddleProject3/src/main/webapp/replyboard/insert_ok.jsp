<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id ="model" class="com.sist.model.BoardModel"/>
<%
	model.boardInsert(request, response); // Controller
%>

<%-- 화면 이동 : list.jsp이동--%>
<c:redirect url="list.jsp"/>