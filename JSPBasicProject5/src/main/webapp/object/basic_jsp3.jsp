<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String serverName =request.getServerName();
		String serverName2 = pageContext.getRequest().getServerName();
		out.println(serverName +"<br>");
		out.println(serverName2);
	%>
</body>
</html>