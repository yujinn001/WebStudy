<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="com.sist.model.*"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id ="model" class ="com.sist.model.BoardModel"/>
<%--
		BoardModel model = new BoardModel()
		출력 형식 : EL
		${출력물} => 일반 변수가 아니다
		           request.getAttribute("key") => request.setAttribute("key","value")
                    ${requestScope.key}
                    => 생략이 가능 => ${key}
                   session.getAttribute("key") => session.setAttribute("key","value")
                   ${sessionScope.key}
             
      JSTL => JSP안에서 java코딩을 최소화 (자바 제어문 => 태그형으로 제작)
      core
         <
      format
      fn
      ----- 보안의 문제가 있다 (거의 사용하지 않는다)
      sql
      xml  
      ----- 사용빈도가 없다             
 --%>
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
	     <img src ="qna.png" style ="width:800px; height :150px;">
	  </div>
	  
	  <div style ="height:5px"></div>
	  <div class="row">
	    <table class= "table">
	     <tr>
	       <td>
	         <a href ="insert.jsp" class ="btn bnt-sm btn-danger">새글</a>
	       </td>
	     </tr>
	    </table>
	    <table class="table">
	      <tr class ="warning">
	         <th width ="10%" class ="text-center">번호</th>
	         <th width ="45%" class ="text-center">제목</th>
	         <th width ="15%" class ="text-center">이름</th>
	         <th width ="20%" class ="text-center">작성일</th>
	         <th width ="10%" class ="text-center">조회수</th>
	      </tr>
	      <c:forEach var ="vo" items="${list }">
	      
	      <tr >
	         <td widtd ="10%" class ="text-center">${vo.no }</td>
	         <td widtd ="45%">
	         <c:if test="${vo.group_tab>0 }">
	           <c:forEach  var="i" begin="0" end ="${vo.group_tab }">
	              &nbsp;&nbsp;	           
	           </c:forEach>
	              <img src ="re_icon.png"> 
	         </c:if>
	         <c:if test="${vo.subject ==msg }">	  
	             <span style="color:gray">${vo.subject}</span>   <!-- 관리자가 삭제한 거를 링크빼기  -->   
	         </c:if>
	         <c:if test="${vo.subject !=msg }">	      
	         <a href ="detail.jsp?no=${vo.no }">${vo.subject}   
	         </c:if>
	         &nbsp;
	         <c:if test ="${today==vo.dbday }">
	           <sup><img src ="new.gif"></sup>
	         </c:if>
	         </td>
	         <td widtd ="15%" class ="text-center">${vo.name}</td>
	         <td widtd ="20%" class ="text-center">${vo.dbday}</td>
	         <td widtd ="10%" class ="text-center">${vo.hit }</td>
	      </tr>
	      </c:forEach>
	    </table>
	  </div>
	</div>
</body>
</html>




















