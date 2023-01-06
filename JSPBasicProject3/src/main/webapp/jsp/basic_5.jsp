<%--
	  스크립트릿 <% %>
	  표현식 <%= %> => 데이터값 출력
	  
	  <%
	  	 제어문 : if, for, while
	  %>
	  => 열고 닫기
	  
	  Chapter 6장
	  -----------
	   지시자 
	   ----
	     page : JSP 파일에 대한 정보 -> 관리하는 클래스(HttpServletResponse)
	        *** contentType => 브라우저 알려주는 기능 (어떤 파일 형식)
	        contentType = "text/html; charset ="ISO-8859-1"
	                                                        ------------- 아스키코드를 사용하게 되면 한글이 깨지게 된다
	                                   "text/html; charset =UT-8"
	                                   
	                                   => XML 변경
	                                    "text/xml; charset=UTF-8"
	                                    
	                                   => JSON
	                                    "text/plain; charset=UTF-8"
	              => 한번만 사용이 가능 (JSP 한 개에서)
	        *** import : 자바 라이브러리를 가지고 올 때 사용
	                     java.lang, javax.servlet
	                     <%@ page language="java" contentType="text/html; charset=UTF-8"
   						 pageEncoding="UTF-8" import ="패키지명, 패키지명.패키지"%>
   						 -----------------------------------------------------------------
   						 <%@ page import ="패키지명">
   						 <%@ page import ="패키지명">
   						 <%@ page import ="패키지명">
   						 
   						 => 지시자의 속성은 반드시 지정된 것만 사용이 가능 (사용자 정의가 없다)
   						    속성명 = "값" 
   						     
	        *** buffer : 출력버퍼 => jsp를 실행 => html을 출력해 둔다
	                                          ------------------ 출력 버퍼 => 브라우저에서 읽어서 출력
	                                           TCP => 신뢰성 (메모리 => 메모리 값)
	                        default : 8kb => 필요시에는 늘려준다 
	                                  16kb, 32kb....
	                       => JspWriter => out (내장 객체)
	                       
	        *** errorPafe : JSP에서 error가 발생시 이동하는 페이지를 지정
	                       ---------------------------------------
	                           서버에서 에러시,  코드 
	                            404 : 파일이 없는 경우 => 파일명, 경로명 변경
	                         ***500 : 자바 소스 파일 에러
	                            415 : 지원하지 않는 한글 변환 코드 사용
	                            400 : Spring에서 주로 나는 에러
	                                  JSP는 개발자가 직접 처리, Spring은 Spring에서 받는다
	                                  bad request
	                            403 : Spring (보안) => 접근 거부
	                            200 : 정상 수행 => 화면
	            info : 파일 정보 => 수정일, 작성자
	            language : default(자바) => JSP안에서 다른 언어 사용이 가능
	            pageEncoding : 한글 변환 코드
	                            UTF-8 => 리눅스, GIT
	                            ECU-KR => default
	                           
	            autoFlush : 새로고침, 페이지 이동 => 출력 버퍼에 내용을 초기화 => true 
	            isErrorPage : 사용 (종류별로 에러를 처리)
	            session : 서버에 정보 저장 (id,장바구니, 예매...)=> true
	            => 한번만 사용이 가능 (단 import는 여러번 사용이 가능)
	   taglib
	   include
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    errorPage="error.jsp"   pageEncoding="UTF-8" info ="2023-01-06 홍길동"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			int a =10/0;
		%>
</body>
</html>