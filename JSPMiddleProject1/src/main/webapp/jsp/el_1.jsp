<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	   EL => <%= %>을 대체 (화면에 데이터 출력) : 표현식
	   -- Spring, 실무
	   자바 제어문 => JSTL
	   ------------------------------------ 자바를 최소화시킨다
	   1) 복잡 (HTML/자바)
	   2) Front / Back => 공동 작업이 가능하게 만든다
	   -----------------------------------------
	   1. 내장 객체 (525)
	      1) requestSccope : request.getAtttribute()
	      2) seesionScope : session.getAttribute()
	      3) param : request.getParameter()
	      => 사용 방식
	         <%= %> ==> ${}
	         <%
	             String name ="홍길동";
	             request.setAttribute("name",name)
	                                  ------ key
	         %>
	         ${requestScope.name}
	                        ---- key
	           ------------- 생략이 가능 => ${name}
	           ${name} => 출력하지 않는다
	             ----- 변수가 아니다
	           <%=name>
      
	   2. 연산자
 --%>
 <%
 	String name ="홍길동";
 	//${}를 이용해서 출력 => request,sessio=> 추가적으로 담아서 출력 => setAttribute()
	request.setAttribute("name", "심청이");
 	session.setAttribute("name1", "심청이22");
 			%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>일반 변수일 때 출력</h1>
  이름: <%= name %><br>
  <h1>EL을 이용</h1>
  이름: ${name} <%-- request.setAttribute("name", "심청이"); --%>
  <br>
  <h1>Session에 저장된 데이터 읽기</h1>
  이름 : ${name1 }  <%--request가 우선 순위이기 때문에 심청이가 우선이당 그래서 이름을 따로 써준다 --%>
  <%-- session.setAttribute("name1", "심청이22"); --%>
</body>
</html>
















