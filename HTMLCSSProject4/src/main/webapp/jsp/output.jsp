<!-- CSS는 모양만 보여준다 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 자바 영역
	// request는 값을 받는다
	// setCharacterEncoding => 한글 변환 => 회원가입
	request.setCharacterEncoding("UTF-8");
	String name =request.getParameter("name");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<b><%=name %></b>
</body>
</html>