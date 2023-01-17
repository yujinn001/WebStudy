<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="com.sist.model.*"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="model" class="com.sist.model.FoodModel"/>
<%
	model.boardListData(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.container{
   margin-top:100px;
}
.row{
   width: 960px;
   margin: 0px auto;
}
</style>
</head>
<body>
	<div class="container">
	  <div class="row">
	     <h1>food_location 테이블</h1>
	     <hr>
  	     <c:forEach var ="vo" items="${list }">
	        <div class="col-md-4">
                   <div class="thumbnail">
                     <a href="food_list.jsp?cno=${vo.fno }">
                       <img src="${vo.poster }" style="width:260px;height: 200px" class="img-rounded">
                       <div class="caption">
                         <p style="font-size: 9px;font-weight: bold">${vo.name }</p>
                       </div>
                     </a>
                   </div>
              </div>
	     </c:forEach>  
	  </div>
	</div>
</body>
</html>
















