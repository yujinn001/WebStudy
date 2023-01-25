<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	// 단항 연산자(++,--,!)
	let a =10;
	let b=a++;
	console.log("a="+a+",b="+b);//a=10, b=a, a=a+1 => b=10, a=11
	
	a=10;
	b=++a;
	console.log("a="+a+",b="+b);
	
	// 주의점
	let d =1;
	d=!d; // 숫자가 들어갔지만 !를 주는순간  true /false로 반환된다
	console.log("d="+d); // false => 모든 숫자가 0, 0.0이 아닌 수는 true
	
	// 형변환 연산자 => 자바에서 전송 (String )
	let e ="10";
	console.log("e="+typeof e)
	console.log("e="+ typeof Number(e))
}
</script>
</head>
<body>

</body>
</html>