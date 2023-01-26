<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	const names =["사과","배","멜론","수박","바나나"]; // 데이터 변경이 없는 경우 => let,const
	document.write("<h1>====일반 for문 사용법 ===</h1>")
	for(let i=0;i<names.length;i++)
	{
		document.write(names[i]+"&nbsp;")
	}
	document.write("<h1>==== for of문 사용법 ===</h1>")
	// for(String s: names)
	for(let f of names)
	{
		document.write(f+"&nbsp;")
	}
	document.write("<h1>==== for in문 사용법 ===</h1>")
	// for(String s: names)
	for(let f in names)
	{
		document.write(names[f]+"&nbsp;") //index번호 읽기
	}
	document.write("<h1>==== map 1사용법 =====</h1>")
	names.map(function(f){
		   document.write(f+"&nbsp;")
	})
	document.write("<h1>==== map 2사용법 =====</h1>")
	names.map((f)=>{
		   document.write(f+"&nbsp;")
	})
	document.write("<h1>==== forEach 1사용법 =====</h1>")
	names.forEach(function(f){
		   document.write(f+"&nbsp;")
	})
	document.write("<h1>==== forEach 2사용법 =====</h1>")
	names.forEach((f)=>{
		   document.write(f+"&nbsp;")
	})
}
</script>
</head>
<body>

</body>
</html>