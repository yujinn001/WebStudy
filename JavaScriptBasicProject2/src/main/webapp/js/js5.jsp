<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	func1();
	func2("홍길동");
	let msg =func3();
	document.write(msg+"<br>");
	let name =("이순신");
	document.write(name+"님 로그아웃입니다")
}
let fun1=function(){
	document.write("func1 Call...<br>");
}
let fun2=(name)=>{
	document.write(name+"님 환영합니다!!<br>");
}
let func3=()=>{
	return "Hello JavaScript";
}
let fun4=(name)=>{
	return name;s
}
/* function func1(){
	document.write("func1 Call...<br>"); // 매개변수, 리턴형이 없는 함수
}
function func2(name){
	document.write(name+"님 환영합니다!!<br>")
}
function func3()
{
	return "Hello JavaScript";	
}
function func4(name)
{
	return name;
	} */
	
</script>
</head>
<body>

</body>
</html>