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
	 ArrayList<SeoulVO> list =dao.seoulListData(curpage, "location");
	 // 페이지 나눔 => 총페이지 가져오기
	 int totalPage =dao.seoulTotalPage("location");
	 // 블록별 페이지
	 final int  BLOCK =5;
	 int startPage =((curpage-1)/BLOCK*BLOCK)+1;
	 int endPage =((curpage-1)/BLOCK*BLOCK)+BLOCK;
	 
	 if(endPage > totalPage)
		 endPage=totalPage;
	 
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
	<div class ="row">
	  <div class ="text-center">
	      <ul class="pagination">
	    <%
	        if(startPage >1)
	        {
	    %>
	      	  <li><a href="../main/main.jsp?mode=1&page=<%=startPage-1%>">&lt;</a></li>
	    <%
	        }
	    %>
	      	<%
	      		for(int i =startPage; i<endPage; i++)
	      		{
	      	%>
			    <li <%=i==curpage?"class=active":"" %>><a href="../main/main.jsp?mode=1&page=<%=i%>"><%=i%></a></li>
			<%
	      		}
			%>
			<%
		        if(endPage <totalPage)
		        {
		    %>
			  <li><a href="../main/main.jsp?mpde=1&page=<%=endPage+1%>">&gt;</a></li>
			<%
		        }
			%>
		  </ul>
	  </div>
	</div>
</body>
</html>