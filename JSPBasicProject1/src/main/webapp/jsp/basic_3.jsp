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
	margin: 0px auto; /*가운데 정렬*/
}
h1{
	text-align:center;
}
</style>
</head>
<body>
	<div class="container">
	  <h1>구구단</h1>
	  <table width=700 border =1 bordercolor =black>
	  	 <tr bgcolor ="pink">
	  	   <%
	  	       for(int i=2;i<=9; i++)
	  	       {
	  	   %>
	  	        <th><%=i+"단" %></th>
	  	   <%  	   
	  	       }
	  	   %>
	  	   </tr>

		  	   </tr>
	  </table>
	</div>
</body>
</html>