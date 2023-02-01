<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <div class="sidebar one_quarter first"> 
      <h6>${sessionScope.name } 님의 마이페이지</h6>
      <%-- 메뉴가 들어가는 위치 --%>
      <jsp:include page="../mypage/mypage_menu.jsp"/>
      </div>
    <div class="content three_quarter"> 
      <jsp:include page="${mypage_jsp }"/>
     </div>
    <div class="clear"></div>
  </main>
</div>
</body>
</html>















