<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!--  전송값 받기 (request) -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
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
</head>
<body>
	<div class ="container"> 
		<h1>개인 정보 전송</h1>
		<div class ="row">
		 <form method =post action="output.jsp"> <!-- action값으로 출력된ek -->
		 <!-- 
		  		method : get / post
		  		         ---------
		  	    action : 받는 파일 지정
		  	    전송되는 데이터 : input / select / textarea => 입력 관련 내용만 전송
		  -->
			<table class="table">
				<tr>
					<th class ="text-center" width="20%">이름</th>
					<td width ="80%">
					  <input type =text name ="name" class="input-sm" size =15>
					  <!-- request.getParameter("name") : 입력된 값을 읽어 온다 
					  	   ?name =홍길동 & sex=남자...
					  	   ------------------------
					  	    POST /GET => 값을 전송하거나 받는 경우(Map) => 키/값
					  -->
					</td>
				</tr>
				<tr>
					<th class ="text-center" width="20%">성별</th>
					<td width ="80%">
					  <input type =radio name =sex  checked value ="남자">남자
					  <input type =radio name =sex   value ="여자">여자
					  <!-- name이 동일 (그룹) , 반드시 보낼 데이터를 설정한다 (value) -->
					</td>
				</tr>
				<tr>
				  <th class ="text-center" width=20%>지역</th>
				  <td width =80%>
				  	<select name ="loc" class="input-sm">
				  		<option>서울</option>
				  		<option>부산</option>
				  		<option>제주</option>
				  		<option>인천</option>
				  		<option>경기</option>
				  		<!-- 
				  			<option>서울</option>
				  			<option vlaue ="seoul">서울</option>
				  			
				  			보통 value값을 컬럼값으로 한다 
				  			=> radio / checkbox는 value값을 지정해줘야 값이 넘어간다!!!!
				  		 -->
				  	</select>
				  </td>
				</tr>
				<tr>
					<th class ="text-center" width : 20%>취미</th>
					<td width = 80%>
						<input type ="checkbox" value ="등산" name =hobby>등산
						<input type ="checkbox" value ="여행" name =hobby>여행
						<input type ="checkbox" value ="게임" name =hobby>게임
						<input type ="checkbox" value ="낚시" name =hobby>낚시
						<input type ="checkbox" value ="독서" name =hobby>독서
						<%-- 전송값 : value , name은 동일 해야한다 : String [] getParameterValues --%>
					</td>
				</tr>
				<tr>
					<th class ="text-center" width : 20%>소개</th>
					<td width = 80%>
					<textarea rows="8" cols="35" name ="content"></textarea>
					</td>
			   </tr>
			   <tr>				
					<td colspan="2" class="text-center">
					  <input type=submit value="전송" class= "btn btn-sm btn-success">
	 				</td>
			   </tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>





























