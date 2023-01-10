<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 번호를 가지고 카테고리 화면 변경?
			
	String mode = request.getParameter("mode");
	if(mode ==null)
		mode ="0";
	int index =Integer.parseInt(mode);
	String jsp ="";
	switch(index)
	{
	case 0: 
		jsp="../food/category.jsp";
		break;
	case 1: 
		jsp="../food/food_list.jsp";
		break;
	case 2: 
		jsp="../food/food_datail.jsp";
		break;
	}
	
		
	
	String log_jsp="";
	String id =(String)session.getAttribute("id");
	if(id==null) // 로그인이 없는 상태
	{
		log_jsp="login.jsp";
	}
	else
	{
		log_jsp="logout.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.main{
	margin-top: 50px;
}
.row{
	width:800px;
	margin: 0px auto;
}
h1{
	text-align: center;
}
</style>
</head>
<body>
	<%
		pageContext.include("header.jsp"); // <jsp:include page ="header.jsp">
	%>
	<div class ="container main">
	  <div class ="col-sm-3"> <!--  화면 분할 -->
	    <%
	       pageContext.include(log_jsp);
	    %>
	  </div>
	  <div class ="col-sm-9"> <!--  화면 분할 -->
	     <%
	       pageContext.include(jsp);
	    %>
	  </div>
	</div>
</body>
</html>




























