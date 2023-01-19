<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>맛집 & 여행</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ae12aff8e45e62ef0437d634b152c8df&libraries=services"></script>
<link href="../css/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<body id="top">
<jsp:include page="header.jsp"></jsp:include>
<!-- ############################################## Header ############################################## -->
<jsp:include page="${main_jsp }"></jsp:include> <!-- mainModel 파일의 키값 -->
<!-- ############################################## Home ############################################## -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- ############################################## Footer ############################################## -->

<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a> 
<!-- JAVASCRIPTS --> 
<script src="../js/jquery.min.js"></script> 
<script src="../js/jquery.backtotop.js"></script> 
<script src="../js/jquery.mobilemenu.js"></script> 
<script src="../js/jquery.flexslider-min.js"></script>
</body>
</html>