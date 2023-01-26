<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	상황
	퇴근길 휴식  휴가 여행  산책 운동  고백 
	감성
	기분전환 외로움 슬픔 힘찬 이별 설렘 오후 위로 밤 새벽 저녁 아침 사랑 스트레스/짜증 그리움 추억 우울 행복 불안 분노 기쁨 축하
	스타일
	밝은 신나는 편안한 따뜻한  로맨틱한  매혹적인 영화음악 잔잔한 몽환적인 댄서블한 달콤한 시원한 애절한 어두운 연주음악 발렌타인데이 화이트데이
	날씨/계절
	봄 여름 가을 겨울 맑은날 추운날 흐린날 비오는날 더운날 안개낀날 눈오는날
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
   margin-top: 30px;
}
.row{
   width: 700px;
   margin: 0px auto;
}
</style>
<script type="text/javascript" src ="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#btn1').val("상황");
	$('#btn2').val("감성");
	$('#btn3').val("스타일");
	$('#btn4').val("날씨/계절");
	
	let arr1=["퇴근길" ,"휴식",  "휴가" ,"여행" , "산책" ,"운동" ,"고백" ];
	let arr2=["기분전환", "외로움", "슬픔" ,"힘찬" ,"이별" ];
	let arr3=["밝은" ,"신나는" ,"편안한" ,"따뜻한" , "로맨틱한"];
	let arr4=["봄" ,"여름" ,"가을" ,"겨울" ,"맑은날" ,"추운날"];

	$('#btn1').click(function(){
		let html='';
		for(let i=0; i<arr1.length; i++)
		{
			html+='<span class="btn btn-sm btn-danger">'+arr1[i]+'</span>&nbsp;'
		}
		$('#sub').html(html)
	})
	$('#btn2').click(function(){
		let html='';
		for(let i=0; i<arr2.length; i++)
		{
			html+='<span class="btn btn-sm btn-success">'+arr2[i]+'</span>&nbsp;'
		}
		$('#sub').html(html)
	})
	$('#btn3').click(function(){
		let html='';
		for(let i=0; i<arr3.length; i++)
		{
			html+='<span class="btn btn-sm btn-info">'+arr3[i]+'</span>&nbsp;'
		}
		$('#sub').html(html)
	})
	$('#btn4').click(function(){
		let html='';
		for(let i=0; i<arr4.length; i++)
		{
			html+='<span class="btn btn-sm btn-warning">'+arr4[i]+'</span>&nbsp;'
		}
		$('#sub').html(html)
	})
}) 
</script>
</head>
<body>
	<div class="container">
	 <div class="row">
	  <div class="text-center">
	   <input type= "button" class="btn btn-lg btn-danger" value="" id="btn1">
	   <input type= "button" class="btn btn-lg bth-success" value="" id="btn2">
	   <input type= "button" class="btn btn-lg btn-info" value="" id="btn3">
	   <input type= "button" class="btn btn-lg btn-warning" value="" id="btn4">
	  </div>
	  <div style="height:10px"></div>
	  <div class="row">
	   <div class="text-center" id="sub"></div>
	  </div>
	 </div>
	</div>
</body>
</html>