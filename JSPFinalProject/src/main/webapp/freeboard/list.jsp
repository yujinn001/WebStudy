<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
   <div class="wrapper row3">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">Lorem</a></li>
      <li><a href="#">Ipsum</a></li>
      <li><a href="#">Dolor</a></li>
    </ul>
    <!-- ################################################################################################ --> 
  </div>
</div>
<!-- ################################################################################################ --> 

<div class="wrapper row3">
  <main class="container clear"> 
    <h2 class="sectiontitle">자유게시판</h2>
   <div style="height: 5px"></div>
				  
   <table class = "table">
     <tr>
       <td>
         <a href="../freeboard/insert.do" class="btn btn-sm btn-danger">새글</a>
       </td>
     </tr>
   </table>
   <table class="table">
     <tr>
      <th width="10%" class="text-center">번호</th>
      <th width="45%" class="text-center">제목</th>
      <th width="15%" class="text-center">이름</th>
      <th width="20%" class="text-center">작성일</th>
      <th width="10%" class="text-center">조회수</th>
     </tr>
     <%--
        for(FreeBoardVO vo:request.getAttribute("list"))
      --%>
     <c:forEach var="vo" items="${list }"> <%--request.setAttribute("list",list) => request.getAttribute("list" ${list} --%>
        <tr>
           <td width=10% class="text-center">${vo.no }</td> <%--${vo.no} = vo.getNO() : get메소드 호출, 변수가 아니다--%>
           <td width=45%>
           <a href ="../freeboard/detail.do?no=${vo.no }">${vo.subject }&nbsp;</a>
           <c:if test="${vo.dbday==today }">
             <sup><img src="../freeboard/image/new.gif"></sup>
           </c:if>
           </td>
           <td width=15% class="text-center">${vo.name }</td>
           <td width=20% class="text-center">${vo.dbday }</td>
           <td width=10% class="text-center">${vo.hit}</td>
        </tr>
     </c:forEach>   
   </table>
		  
   <table class="table">
     <tr>
       <td class="text-center">
          <a href="../freeboard/list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-primary">이전</a>
             ${curpage } page / ${totalpage } pages
          <a href="../freeboard/list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-primary">다음</a>
       </td>
     </tr>
   </table>
  </main>
</div>
</body>
</html>

















