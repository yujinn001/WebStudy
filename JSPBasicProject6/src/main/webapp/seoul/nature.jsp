<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.*,com.sist.dao.*,com.sist.vo.*"%>
<jsp:useBean id="dao" class ="com.sist.dao.SeoulDAO"/>
<%
     // 자바에서 오라클에 있는 데이터를 읽어 온다
     // 1. 사용자가 보내준 값을 받는다 : page
     String strPage =request.getParameter("page");
	 // 첫페이지가 지정되지 않았을 경우 조건문을 사용하여 지정한다
	 if(strPage ==null)
		 strPage ="1";
	 int curpage =Integer.parseInt(strPage);
	 // 해당 페이지의 값을 가지고 온다
	 ArrayList<SeoulVO> list =dao.seoulListData(curpage, "nature");
	 // 페이지 나눔 => 총페이지 가져오기
	 int totalPage =dao.seoulTotalPage("nature");
	 // 블록별 페이지
	 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
	   <%
	       for(SeoulVO vo : list)
	       {
	   %>
	           <div class="col-md-3"> <!-- 3을 주면 4등분 => 총 12개? -->
				    <div class="thumbnail">
				      <a href="#">
				        <img src="<%=vo.getPoster() %>" style="width:260px; height:260px">
				        <div class="caption">
				          <p style ="font-size:9px; font-weight:bold"><%=vo.getTitle() %></p>
				        </div>
				      </a>
				    </div>
				  </div>
	   <% 
	       }
	   %>
	</div>
</body>
</html>