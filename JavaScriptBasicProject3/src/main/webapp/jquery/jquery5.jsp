<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img{
  width:150px;
  heigh :150px;
}
img:hover{
	border-radius:50px;
}
</style>
<script type="text/javascript" src ="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
//태그 추가 : append => 제거 remove()
$(function(){
	$('img').hover(function(){
		$(this).addclass('hover')
	},function(){
		//$(this).removeClass();
		$(this).fadeToggle('slow')
	})
})
</script>
</head>
<body>
	<img src="1.jpg">
	<img src="2.jpg">
	<img src="3.jpg">
	<img src="4.jpg">
	<img src="5.jpg">
</body>
</html>