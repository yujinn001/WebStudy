<%--
	    C/S => 17page
	    ---
	    Client / Server (결과값을 전송 ) => 동적 페이지 (JSP...)
	    ------
	    실행되는 프로그램 (HTML) => 정적페이지
	    Client : 브라우저 / 핸드폰 => 요청
	    Server : 요청을 받아서 처리 
	            ----------------
	                웹서버 => 아파치(Java) / IIS(MS)
	                		 프로그램 번역 기능이 없다 (HTML/ XML /Json)
	                웹컨테이너 => 톰캣 (자바를 번역해서 => HTML, XML로 변환)
	                            |
	                           테스트용 웹서버 (50명) => AWS (리눅스) => 과금 (인스턴스)빌리기 => Pa
	                           ------------------                 =>IP(고정IP)
	                                                              => IP지우고 인스턴스 지우기
	               => Servelet  
	                 ----------- sever+ Applet (let => 가벼운 프로그램)
	                     |
	                  순수하게 자바 => 변경시 마다 컴파일을 한다 (개발자 => 코딩과 동시에 결과) => JSP파일
	                  JSP => 스크립트 형식으로 제작 => 실행과 동시에 변경이 가능
	                  --- 자바 / HTML분리, 보안 취약하다 (JSP자체), 재사용성이 없다, 반복코딩이 많이 존재
	                      ----------------------------------------------------------------
	                                     |
	                                    MVC (최근 JSP : View =>  front)
	                                    ---
	                                     |
	                                     M => back 
	                                     V => front
	                                     C => 연결 => Controller
	                                                ------------ 스프링에서 제작되어있다
	             클라이언트 : 파일 요청 => URL (파일명)
	             서버 : 파일을 찾아서 요펑한 사용자의 브라우저로 전송 
	                                          ----------- 브라우저에서 실행하는 파일을 전송(HTML, XML)
	                                                                               ------------JSP 실행
	             클라이언트 => 요청 (HttpServletRequest) => 요청 정보 (보내는 값, IP, PORT)
	             서버     => 요청 처리 후에 응답 (HttpServletResponse)
	             
	             24page
	               JSP : 웹 프로그램 언어는 동적으로 페이지를 생성하기 위한 서버측 스크립트 언어
	                                                                 ----------- 단순한 언어
                         사용가능언어 : Java, HTML
                         사용가능기술 : JSP, Servlet, Spring...
                      JSP안에서는 Java + HTML 
                                ------------ 구분
                                자바코딩 : <% %>
                                브라우저에 출력 : <%= %>
                                메소드, 변수 선언 : <%! %>
                                ----------------------- 영역을 벗어나면 브라우저 일반 텍스트
 			                    
 
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>