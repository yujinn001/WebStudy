<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	let arr=["홍길동",20,'A',30.5,"영업",3500]//여러데이터형을 혼합 가능
	for(let data of arr)
	{
		document.write(data+"<br>")
	}
	// 객체 형식으로 변경 ===> JSON
	let sawon={sabun:1,name:"홍길동",age:20,dept:"영업부",pay:3500}
	document.write("<h1>==== 자바스크립트 객체 사용법(JSON)1 ====</h1>")
	document.write("사번 :"+sawon.sabun+"<br>")
	document.write("이름 :"+sawon.name+"<br>")
	document.write("나이 :"+sawon.age+"<br>")
	document.write("부서 :"+sawon.dept+"<br>")
	document.write("급여 :"+sawon.pay+"<br>")
	
	document.write("<h1>==== 자바스크립트 객체 사용법(JSON)2 ====</h1>")
	document.write("사번 :"+sawon['sabun']+"<br>")
	document.write("이름 :"+sawon['name']+"<br>")
	document.write("나이 :"+sawon['age']+"<br>")
	document.write("부서 :"+sawon['dept']+"<br>")
	document.write("급여 :"+sawon['pay']+"<br>")
	
	document.write("<h1>==== 자바스크립트 객체 사용법(JSON)3 ====</h1>")
	/* document.write("사번 :"+sawon[0]+"<br>")
	document.write("이름 :"+sawon[1]+"<br>")
	document.write("나이 :"+sawon[2]+"<br>")
	document.write("부서 :"+sawon[3]+"<br>")
	document.write("급여 :"+sawon[4]+"<br>") */
}
</script>
</head>
<body>

</body>
</html>