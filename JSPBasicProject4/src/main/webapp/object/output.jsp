<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   /*
      1. 사용자가 보내준 데이터를 받는다
   // 2. 데이터베이스 연동
   // 3. 화면 이동 / 출력
         ------
         회원가입, 회원수정 한 후 main 페이지로 이동 시키도록 유도
         글쓰기 => 목록
       
   // name, sex, loc, hobby, content
      -------------        -------- > 낱개
   */
   request.setCharacterEncoding("UTF-8");
   String name=request.getParameter("name");
   String sex=request.getParameter("sex");
   String loc=request.getParameter("loc");
   String[] hobby=request.getParameterValues("hobby");      
   String content=request.getParameter("content");
   // <input type=text,password...>,<textarea>,<select> = request.getParameter
   // <input type=checkbox> = request.getParameterValues()
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>전송값 출력</h1>
   <!-- 
   디코딩 안해서 한글 출력시 오류
   체크박스 체크 안할 시 오류
    -->
    이름:<%= name %><br>
    성별:<%= sex %><br>
    지역:<%= loc %><br>
    취미:
       <ul>
        <%
           if(hobby!=null){
           for(String h:hobby){
        %>
           <li><%=h %></li>
        <%
           }
           } else{
        %>
              <span style="color: red">취미가 없습니다</span>
        <%
           }
        %>
       </ul>
    소개:<%= content %><br>
    
</body>
</html>