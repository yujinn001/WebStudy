<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload =function()
{
	let a =5;
	let b=2;
	console.log("a+b="+(a+b));
	console.log("a-b="+(a-b));
	console.log("a*b="+(a*b));
	console.log("a/b="+(a/b));
	console.log("a%b="+(a%b));
	
	// +=> 문자열 결합, 산술 처리
	let c="10";
	let d="20";
	// String형
	console.log("c+d="+(c+d))
	// 자바와 다르다
	console.log("c-d="+(c-d)) // 문자형 => 숫자형으로 변환
	console.log("c*d="+(c*d))
	console.log("c/d="+(c/d))
	console.log("c%d="+(c%d))
	
	let e ="10"
	let f =20;
	//console.log("e+f="(e+f))//1020 => 문자열 + 숫자 => 문자열(산술 연산자 =>+(문자열, 산술),*/-%는 숫자 변환후 처리)
	
	// 주의점
	let m ='A';
	let n =10;
	console.log("m+n="(m+n)) //A10
	console.log("m-n="(m-n)) // 연산 결과값이 없다 => NaN
	
	let k =10;
	let p=0;
	console.log("k/p="+(k/p))// Infinity => 0으로 나눌수 없다(293page)
	
}
</script>
</head>
<body>

</body>
</html>