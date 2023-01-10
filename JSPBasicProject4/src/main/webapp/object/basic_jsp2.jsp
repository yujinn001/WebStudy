<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
    request의 주요 메소드 : 브라우저 / 서버정보
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>request의 정보 얻기</h1>
	서버 주소 : <%=request.getServerName() %> <br> <!-- localhost -->
	서버 포트 : <%=request.getServerPort() %> <br> <!-- 8080 -->
	URL : <%=request.getRequestURL()%> <br>
   ★URI(요청경로) : <%=request.getRequestURI() %> <br>
   ★루트경로 : <%=request.getContextPath() %> <br> <!-- 루트경로 : /JSPBasicProject4 -->
   ★IP : <%= request.getRemoteAddr() %> <br> 
	요청 문장 : <%=request.getQueryString() %><br> 
</body>
</html>