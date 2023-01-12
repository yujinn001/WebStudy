<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="com.sist.change.*"%>
<%--
	  JSP => 자바 코딩 영역
	     1) <% %> : 스크립트릿 = 자바 일반 코딩 (제어문, 메소드 호출, 변수 선언)
	                MVC, Spring => 일반 자바 파일로 변경
	     2) <%= %> : 표현식 = 변수나 메소드의 리턴값을 출력
	                  MVC, Spring =>${}
	     3) 제어문
	        <%
	           for()
	           {
	        %>
	        <% 
	           }
	        %>
	        -------------
	        => 제어문 => JSTL
	        <c:forEach>
	           출력
	        </c:forEach>
	        
	        <%
	           if()
	           {
	        %>
	        <% 
	           }
	        %>
	        <c:if>
	           출력
	        </c:if>
	        ------------------------------- HTML에서 제어문을 사용 (ThymeLeaf)
	   ==> 지시자 (선언)
	       <%@ %> : 정보, 라이브러리 로딩
	       ***page
	          contentType ="text/html;chareset="UTF-8"
	          errorPage=""
	          isErrorPage=""
	          import =""
	          
	       ***taglib
	          prefix ="c" => <c:~>
	          uri=""
	       
	          include => 액션 태그로 대체 <jsp:include>
	     
	    ==> 내부 객체
	        request : 요청 정보, 추가 정보 
	          = getParameter() : 단일값 
	          = getParameterValues() : 다중값 (checkbox)
	          = setCharaterEncoding() : 한글 변환
	          = setAttribute(),getAttribute() => MVC , getRequestURI(), getContextPath()
	          = getCookie(), getSession()
	          = 
	        
	        response
	          => setHeader() : 업로드 / 다운로드
	          => sendRedirect() : 실행할 파일 지정 => request가 초기화
	          
	        session : 서버에 클라이언트의 정보를 저장
	          => setAttribute() 저장
	          => getAttribute() : 읽기
	          => invalidate() : 전체 해제
	          => removeAttribute() : 한개 삭제 => 장바구니
	          
	        application
	          getRealPath() : 실제 저장된 경로를 가지고 온다
	          
	        out
	          out.println() => <%= %> => ${} => 출력(메모리)= > 출력버퍼
	          
	        pageContext
	          => 웹 흐름(페이지 연결) => 파일 (페이지)
	             include => <jsp:include>
	             forward => <jsp:forward>
	        -------------- MVC, Spring
	        
	        exception : try~catch
	        config : web.xml
	        page : this
	        ------- 사용빈도가 거의 없음
	        
	    ==> 액션 태그
	         <jsp:include>: JSP안에 특정 부분에 다른 JSP를 포함해서 사용
	         <jsp:useBean>: 자바 객체 생성
	         <jsp:setProperty>: 자바객체에 setXxx()메소드를 호출해서 데이터값을 입력
	         
	    ==> 자바빈 : ~VO, ~DTO, ~Bean => 데이터를 모아서 전송할 목적
	              ------------------
	               캡슐화 방식을 이용한다 (변수 : private , 메소드 : public)
	                               --------------- 읽기 / 쓰기  읽기 : getter, 쓰기: setter
	   
	    ==> 데이터베이스 / JDBC
	        ----------- getConnection(), 보안 => 일반화 (모든 개발업체에서 사용이 된다)
	          JDBC ====> DBCP ====> ORM(실무)
	        ---------------------------------------------------------------- 일반 JSP
	        
 --%>
<%
	// 화면 변경에 대한 요청값을 받는다
	String mode= request.getParameter("mode");
	// 처음에 한번은 default 지정
	if(mode==null)
		mode="0";
    String jsp=JspChange.change(Integer.parseInt(mode));
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
	width:960px;
	margin :0px auto;
}
</style>
</head>
<body>
   <%-- 메뉴 : include (pageContext) : <jsp:include>:pageContext.include() --%>
   <jsp:include page="header.jsp"/>
   <div class ="container">
    <!-- 화면 출력 : 사용자가 메뉴 클릭시마다 화면 변경 -->
      <jsp:include page="<%=jsp %>"></jsp:include>
   </div>
</body>
</html>






































