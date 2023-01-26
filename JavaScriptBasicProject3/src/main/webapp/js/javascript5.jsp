<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
//전역변수 = 자바에서 보내준다
let sawons=[
   {sabun:1,name:"홍길동",dept:"개발부",job:"대리",pay:4500},
   {sabun:2,name:"박문수",dept:"자재부",job:"사원",pay:3500},
   {sabun:3,name:"이순신",dept:"개발부",job:"과장",pay:5500},
   {sabun:4,name:"심청이",dept:"총무부",job:"부장",pay:6500},
   {sabun:5,name:"강감찬",dept:"영업부",job:"대리",pay:4500},
																	   
]

window.onload=function(){
   sawonList();
   sawonDetail(3);
   sawonInsert();
   sawonDelete();
   sawonSlice();
}
const sawonList=function(){
   console.log(sawons);
}
const sawonDetail=(sabun)=>{
   //find()는 객체 단위로 출력
   let sawon=sawons.find(sa=>sa.sabun==sabun) //sa={sabun:3,name:"이순신",dept:"개발부",job:"과장",pay:5500}
   console.log(sawon)
}
const sawonInsert=function(){
	sawons.push({sabun:6,name:"을지문덕",dept:"영업부",job:"대리",pay:4500})
	console.log(sawons);
}
	
const sawonDelete=()=>{
	sawons.pop();
	console.log(sawons);
}
const sawonSlice=()=>{
	let sa=sawons.slice(1,3)
	console.log(sa);
}
											
				   
 
</script>
	   
<body>

</body>
</html>