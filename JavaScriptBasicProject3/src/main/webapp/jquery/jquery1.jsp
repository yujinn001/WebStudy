<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src ="http://code.jquery.com/jquery.js"></script>
<%-- 주의점 : 버전시 충돌시에는 실행이 안된다 : main.jsp --%>
<script type="text/javascript">
/*
 *  jquery : 자바스크립트 라이브러리
    -------------------------- 태그 제어 (CSS 적용, 화면 출력, 자바연동(Ajax)) => 연산자, 제어문, 변수는 자바스크립트를 이용
    jquery의 핵심 : selector(태그 선택자)
    	          document.querySelector("선택자") => $("선택자")
 */
$(function(){
	// selector => 371page $("선택자").이벤트처리 , $("선택자").값읽기/값설정
	$('.a').css("color","green");
	$('#b').css("color","red")
})
</script>
</head>
<body>
	<h1>Hello Jquery</h1>
	<h1 class="a">Hello Jquery</h1>
	<h1>Hello Jquery</h1>
	<h1>Hello Jquery</h1>
	<h1 class="a">Hello Jquery</h1>
	<h1>Hello Jquery</h1>
	<h1 class="a">Hello Jquery</h1>
	<h1 id ="b">Hello Jquery</h1>
</body>
</html>