<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	System.out.println("redirect.jsp:id=>"+id);
	//이동 => sendRedirect는 화면을 이동시키지만 사용자의 값을 저장하고 있지 않는다
	response.sendRedirect("basic_jsp5.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>