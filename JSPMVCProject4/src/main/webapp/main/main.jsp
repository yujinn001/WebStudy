<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=474ea1f30b292f1e0644ae92fbff2778&libraries=services"></script>
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
   <jsp:include page="header.jsp"></jsp:include>
   <div class="container">
      <jsp:include page="${main_jsp }"></jsp:include>
   </div>
</body>
</html>