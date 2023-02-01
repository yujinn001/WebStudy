<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src = "http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
   $('#updateBtn').on('click',function(){ // click했다면 function을 실행해라
      let name = $('#name').val(); //입력값 가져옴
      if(name.trim() === ""){ //유효성검사
   
         $('#name').focus();
         return;
      }
      
      let subject = $('#subject').val(); //입력값 가져옴
      if(subject.trim() === ""){ //유효성검사
         $('#subject').focus();
         return;
      }
      
      let content = $('#content').val(); //입력값 가져옴
      if(content.trim() === ""){ //유효성검사
         $('#content').focus();
         return;
      }
      
      let pwd = $('#pwd').val(); //입력값 가져옴
      if(pwd.trim() === ""){ //유효성검사
         $('#pwd').focus();
         return;
      }
      
      let no = $('#no').val();
      let queryString=$('#update_frm').serialize(); //form태그에 입력된 모든 데이터를 한번에 읽어서 전송
      //alert(queryString);
      //데이터 보내기
       $.ajax({
         type : 'post',
         url : '../freeboard/update_ok.do',
         data : queryString, //serializze()를 통해서 모든 쿼리 전송
         // {"no":no, "name":name, "subject":subject, "content":content, "pwd":pwd},
         success : function(result){
	
            let res = result.trim();
            if(res === 'no'){ // 비밀번호가 틀려서 수정이 안되는 경우
               alert("비밀번호를 다시 입력해 주세요.")
									 
																	  
               $('#pwd').val("");
                 $('#pwd').focus();
                 
            }else{ // 비밀번호가 맞는 경우
		
	 
									 
               location.href = "../freeboard/detail.do?no=" + no;
            }
         }
      })
      
      
      
   })
})
</script>
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
    <h2 class="sectiontitle">수정하기</h2>
   <div style="height: 5px"></div>
   <form id="update_frm">
   <table class="table">
     <tr>
       <th width=15% class="text-right">이름</th>
       <td width=80%>
          <input type=text name=name size=20 class="input-sm" value="${vo.name }" id="name">
          <input type=hidden name=no value="${vo.no }" id="no">
       </td>
     </tr>
     
     <tr>
       <th width=15% class="text-right">제목</th>
       <td width=80%>
          <input type=text name=subject size=60 class="input-sm" value="${vo.subject }" id="subject">
       </td>
     </tr>
     
     <tr>
       <th width=15% class="text-right">내용</th>
       <td width=80%>
          <textarea rows="10" cols="60" name="content" id="content">${vo.content }</textarea>
       </td>
     </tr>
     
      <tr>
       <th width=15% class="text-right">비밀번호</th>
       <td width=80%>
          <input type=password name=pwd size=15 class="input-sm" id="pwd">
       </td>
     </tr>
     
     <tr>
       <td colspan="2" class="text-center">
         <input type=button value="수정" class="btn btn-sm btn-danger" id="updateBtn">
         <input type=button value="취소" class="btn btn-sm btn-danger" onclick = "javascript:history.back()">
       </td>
     </tr>
   
   </table>
   </form>
  </main>
 </div>
</body>
</html>