<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/*
 *  자바스크립트 : 동적 (태그 제어) => 클릭, 변경, 마우스, 키보드
                             => 데이터를 변경하기 위해서는 어느 태그에 값을 첨부, 스타일
                    1) 태그를 가지고 오는 방법 (문서 객체 모델 : 335page)
                       태그 1개
                         => document,getElementById("아이디명") => 아이디 중복 없는 속성
                           = Element(태그), Attribute(속성)
                             태그 <a href=""> => a는 클래스, href는 멤버 변수 => object
                             모든 태그명은 클래스로 인식, 속성 멤버로 인식
                             let a = document.getElementById("aaa");
                             a.href a.target
                         => document.querySelector("#아이디명"); => CSS (id=#, class=.)
                         ---------------------------------------------------------------- 라이브러리화 Jquery
                             ------ 문서 저장 (브라우저 = 출력화면)
                         
                        태그 여러개
                         => document.getElementsByName("이름") => <input type =text name="">
                                        -------- name을 동일 (checkbox, radio)
                         => document.getElementsByClassName("클래스명")
                         => document.querySelector(선택자)
                                                  ------- 태그를 선택할 때 (CSS)
 */
 window.onload=function(){
    document.querySelector("h1").style.color='red';  
    document.querySelector("h1").style.backgroundColor='yellow';  
    document.querySelector("h2").style.color='blue';
    document.querySelector("#id").value="admin";
    document.getElementById("id").value="hello";
 }
</script>
</head>
<body>
	<h1>Hello</h1>
	<h2>JavaScript</h2>
	<input type =text id="id" size=20>
</body>
</html>















