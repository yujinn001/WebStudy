<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.*,com.sist.dao.*"%>
<%--
		                 Cookie와 Session
		                 ----------------
     1. 저장공간이 다르다     클라이언트 브라우저에 저장 (보안 취약), 서버 메모리에 저장 (보안)
     
     2. 동일점은 생성시에는 request로 생성
         request.getCookie()
         request.getSession()
         
     3. 저장 => cookie (문자열만 저장), session(Object저장)
     4. 동일점 : Map형식 (키, 값) => 키가 동일하면 덮어쓴다~~
     
     ------------------------------------------------------------------------
	  주요 메소드
	  Cookie
	     1. 생성
	     2. 저장위치 지정
	     3. 저장 기간 
	     4. 브라우저 전송
	     5. 쿠키 읽기 
	     6. 삭제 
	     
	  Session	 
 --%>
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
		jsp="../food/food_detail.jsp";
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
	
	
	
	// 쿠키 처리
	// 1. 쿠키 읽기
	Cookie[] cookies =request.getCookies();
	ArrayList<FoodVO> cList =new ArrayList<FoodVO>();
	FoodDAO  dao = new FoodDAO();
	if(cookies != null) // cookie가 존재한다면
	{
		for(int i=cookies.length-1; i>=0; i--)
		{
			if(cookies[i].getName().startsWith("f"))
			{
				/*
				   new Cookie (키, 값)
				              -------- 중복 저장을 할 수 없다 => f 맛집 번호
				   키
				   값
				*/
				String fno = cookies[i].getValue();
				FoodVO vo = dao.foodDetailData(Integer.parseInt(fno));
				String poster = vo.getPoster();
				poster =poster.substring(0, poster.indexOf("^")).replace("#","&");
				vo.setPoster(poster);
				cList.add(vo);
			}
		}
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
<!-- <script type="text/javascript" src ="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.radios').on('click',function(){
		console.log("click");
		let fno =$(this).attr("value");
		console.log("fno");
		$('#cookie_frm'+fno).submit();		
	})
})
</script> -->
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
	    <div style="height :20px"></div>
	      <h3>최신 방문 맛집 &nbsp; 더보기 &nbsp; <a href ="../food/cookie_delete.jsp"><small>전체 삭제</small></a></h3>
	       <hr>

	       <form method = post  action ="../food/cookie_one_delete.jsp" id ="cookie_frm">
      		<button class="btn btn-sm btn-danger">삭제</button>
         <%
            for(int i=0;i<=cList.size();i++)
            {
               if(i<5)
               {
                  FoodVO vo=cList.get(i);
         %>
               <!--form의 id에 vo.getFno를 해서 id를 다르게 한다 그래서 한번에 삭제 되는게 아니라 각각 삭제되게 만든다 -->
         	      
         	      <input type ="radio" name = "cookie" value="<%=vo.getFno() %>" class ="radios">
                  <img src="<%=vo.getPoster() %>" title="<%=vo.getName()%>" style="width:150px; height:150px">                                            	               
         <%   
               }
            }
         %>
          
	    </form>   
	  </div>
	</div>
</body>
</html>




























