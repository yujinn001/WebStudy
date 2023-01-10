<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	   내부객체  : request,response, session
	           --------------------------
	            out => <%= %> out.prontln()
	   = appliction : 서버 관리
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>application 객체 (ServletContext)</h1>
	서버 이름 : <%=application.getServerInfo() %><br>
	버전: <%= application.getMajorVersion()+"."+application.getMinorVersion() %><br>
	실제 경로명 : <%=application.getRealPath("/") %><br>
 <%-- log => web.xml을 읽어 온다 (xml이나 , 한글 변환 등록 ) --%>
 <%
 	 String driver =application.getInitParameter("driver");
 	 String url = application.getInitParameter("url");
 	 String username =application.getInitParameter("username");
	 String password = application.getInitParameter("password");
	 
	 application.log ("드라이버명 : "+driver);
	 application.log ("오라클 연결 주소 : "+url);
	 application.log ("사용자 : "+username);
	 application.log ("비밀번호 : "+password);
 %>
</body>
</html>