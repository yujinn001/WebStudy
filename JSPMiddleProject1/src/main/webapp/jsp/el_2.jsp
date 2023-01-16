<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	  EL => 연산자 (자바가 아니다) => + 만으로 문자열 결합을 할수가 없어서 += 기호를 사용한다
	  1) 산술 연산자
	     + : 순수하게 산술 연산만 가능 (문자열 결합(x)) => +=
	     -
	     *
	     / : 정수 / 정수 = 실수 div
	     % : 나머지  mod
	     
	     ${10+10} => 20 => 자동으로 변환이 된다
	     ${"10"+10}=> 오류 발생 
	     ${null+10}=10
	     
	  2) 비교 연산자 
	      결과 : true/false : 조건문 사용시  
	      == (eq)
	      != (ne)
	      <  (lt)
	      >  (gt)
	      <= (le)
	      >= (ge)
	      
	      주의점 : 문자열, 날짜 숫자가 동일하다
	      
	  3) 논리 연산자
	     && (and)
	     || (or)
	     ,  (not)
	     
	  4) 삼항 연산자
	     조건? 값1: 값2
	  
	  5) Empty
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<h1>EL 연산자 (산술 연산자)</h1>
	&#36; {10+10}=${10+10}<br>
	&#36; {"10"+10} =${"10"+10} <br>
	 --%>
</body>
</html>













