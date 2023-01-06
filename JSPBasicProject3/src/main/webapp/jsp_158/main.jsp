<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
	width:960px;
	height:800px;
	margin:  0px auto;
	border:1px solid black;
}
.header{
	width: 100%;
	height:150px;
	background-color: "red";
}
.content{
 	width: 100%;
	height:500px;
	background-color: "green";
}
.footer{
	width: 100%;
	height:150px;
	background-color: "pink";
}
</style>
</head>
<body>
	<div class="container">
	 	<div class="header"><jsp:inclue page="header.jsp"/></div>
	 	<div class="content"><jsp:inclue page="content.jsp"/></div>
	 	<div class="footer"><jsp:inclue page="footer.jsp"/></div>
	</div>
</body>
</html>