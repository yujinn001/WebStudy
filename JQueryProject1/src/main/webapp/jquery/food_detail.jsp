<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="com.sist.dao.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id ="dao" class="com.sist.dao.FoodDAO"/>
<%
	String fno=request.getParameter("fno");
	FoodVO vo =dao.foodDetailData(Integer.parseInt(fno));
	//request.setAttribute("vo", vo); // 최대한 자바를 줄이기 위해 c:set을 사용해서 한다
%>
<c:set var ="vo" value="<%=vo %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table class="table">
   <tr>
    <c:forTokens items="${vo.poster }" delims="^" var="img">
      <td><img src ="${img }" style="width:100%"></td>
    </c:forTokens>
   </tr>
  </table>
  <div style="heght:10px"></div>
  <table class="table">
    <tr>
     <td colspan="2">
      <h3>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></h3>
     </td>
    </tr>
    <tr>
     <th width=30%>주소</th>
     <th width=70%>${vo.address }</th>
    </tr>
    <tr>
     <th width=30%>전화</th>
     <th width=70%>${vo.tel }</th>
    </tr>
    <tr>
     <th width=30%>음식종류</th>
     <th width=70%>${vo.type }</th>
    </tr>
    <tr>
     <th width=30%>주차</th>
     <th width=70%>${vo.parking }</th>
    </tr>
    <tr>
     <th width=30%>영업시간</th>
     <th width=70%>${vo.time }</th>
    </tr>
    <tr>
     <th width=30%>메뉴</th>
     <th width=70%>${vo.menu }</th>
    </tr>
  </table>
</body>
</html>




















