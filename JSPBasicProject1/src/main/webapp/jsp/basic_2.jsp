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
	    // Java
		for(int i=1;i<=10;i++)
		{
	%>		
			<!-- html -->
			<b><%=i  %></b><br>
	<%
		}
		
	%>
</body>
</html>