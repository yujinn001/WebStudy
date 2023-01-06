<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.vo.*"%>
<%
	request.setCharacterEncoding("UTF-8");//한글 깨짐 방지
	
%>
<%--
		<jsp:useBean id="bean" class="com.sist.vo.MyBean">
			<jsp:setProperty name ="bean" property="*"/>
		</jsp:useBean>


	    // 1-1. 한글 변환
		request.setCharacterEncoding("UTF-8");
		// 1-2. 데이터 받기
		String name =request.getParameter("name");
		String sex =request.getParameter("sex");
		String loc =request.getParameter("loc");
		String content =request.getParameter("content");
		
		MyBean bean = new MyBean();
		bean.setName(name);
		bean.setSex(sex);
		bean.setLoc(loc);
		bean.setContent(content);

	    public String beanData(MyBean vo)
 --%>
<jsp:useBean id="bean" class="com.sist.vo.MyBean">
	<jsp:setProperty name ="bean" property="*"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>개인 정보 출력</h1>
	이름: <jsp:getProperty name ="bean" property="name"/> <br> <!-- getName호출 -->
	성별: <jsp:getProperty name ="bean" property="sex"/>  <br> 
	지역: <jsp:getProperty name ="bean" property="loc"/>  <br>
	소개: <jsp:getProperty name ="bean" property="content"/>  <br>
</body>
</html>