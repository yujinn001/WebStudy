<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	JSP :  Java Server Page => 서버에서 실행되는 파일 
	        JSP = Java + HTML
	        
	 실행과정 :
	 1) 사용자가 요청 URL(파일명)
	    =http://localhost:8080/JSPBasicProject1/jsp/basic_1.jsp
	                                               -------------
	                                                 *** 파일의 확장명을 변경할 수 있다
	                                                 *** 파일 (구분자)
	 2) 톰갯이 요청을 받는다
	 3) 파일 찾기
	     = 찾은 경우 
	     3-1) jsp 파일을 자바파일로 변경 basic_1_jsp.java 
	     3-2) 변경된 파일을 컴파일을 한다 basic_1_jsp.class
	     3-3) JVM에서 .class파일 로딩
	     3-4) 한줄씩 번역을 시작 (인터프리터)
	     3-5) 메모리에 HTML만 출력한다
	     3-6) 출력된 HTML을 브라우저에서 읽어서 출력
	     
	     = 못 찾은 경우 => 404 화면을 보여준다
    
    소스 코딩 : 
       1. Java 영역
       		1) <%@ page import =""%>
       		2) 일반 자바 코딩 영역
       		    <%
       		       자바 영역
       		       변수 선언
       		       제어문
       		       메소드 호출
       		       문법은 자바와 동일
       		       주석 : // /**/
       		    %>
       		3) 출력 : 변수값
       		   <%= 변수%>
       		   
       2. HTML 영역
          <%@ %> <% %> <%= %>를 제외한 영역
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>