<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="16kb"%>
<%-- 
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int size =out.getBufferSize();
		int re = out.getRemaining();
		out.println("total: "+size);
		out.println("remain:"+re);
	%>
	<br>
	총버퍼 크기 :     <%= "total: "+size%><br>
	남아있는 버퍼 크기 : <%="remain:"+re %><br>
	사용 중인 버퍼 크기 : <%=size-re %><br>
</body>
</html>