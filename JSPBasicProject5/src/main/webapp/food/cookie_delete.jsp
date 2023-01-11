<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		 클라이언트 브라우저에 저장
		 1. 생성 
		 Cookie cookie = new Cookie("f"+fno,fno);
	 	 2. 저장 기간 설정
	 	 setMaxAge(초) => 60*60*24
	 	 3. 저장의 위치 설정
	 	 setPath ("/")
	 	 4. response를 이용해서 클라이언트로 전송
	 	 adCookie()
	 	 ** 문자열만 저장할 수 있다
 --%>
<%
	Cookie[] cookies =request.getCookies();
	if(cookies!=null)
	{
		for (int i =0; i<cookies.length; i++)
		{
			if(cookies[i].getName().startsWith("f"))
			{
				cookies[i].setPath("/");
				cookies[i].setMaxAge(0); // 삭제
				response.addCookie(cookies[i]);
			}
		}
	}
	// 이동
	response.sendRedirect("../include/main.jsp");
%>