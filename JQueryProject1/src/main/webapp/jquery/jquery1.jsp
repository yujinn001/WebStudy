<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src ="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
/*
 *   1. 제이쿼리 => 대부분의 브라우저에서 사용이 가능 (호환성)
 	 2. HTML DOM을 쉽게 조작이 가능, 간단하게 CSS적용이 가능
 	 3. 라이브러리가 많이 존재, 문서가 많다 (참조할)
     4. 오픈 소스 => 사용이 자유롭게
     5. 자바스크립트를 표준화 => 형식이 동일
     6. 단점 => 현재상태 업그레이드가 없다 => 가상돔(가상 메모리)
     7. 예전에 개발된 제이쿼리가 많이 존재 (유지보수)
     8. 약간의속도가 늦다 (라이브러리가 많다 = 무겁다)
 */
 $(function(){
	// $('h1:eq(2),h1:eq(3)').css("color","red") // 복합(,로 구분)
	// $('h1:first').css("color","green")
	// $('h1:last').css("color","blue")
	$('h1:even').css("color","yellow")
	$('h1:odd').css("color","magenta")
 })
</script>
</head>
<body>
	<h1>Hello Jquery</h1>
	<h1>Hello Jquery</h1>
	<h1>Hello Jquery</h1>
	<h1>Hello Jquery</h1>
	<h1>Hello Jquery</h1>
</body>
</html>