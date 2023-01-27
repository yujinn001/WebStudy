<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.container {
   margin-top: 30px;
}

.row {
   width: 960px;
   margin: 0px auto;
}
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
   $.ajax({
      type:'post',
      url:'food_location.jsp',// 실행된 파일을 읽어온다
      data:{"page":1},
      success:function(result)//HTML을 읽어온다 => HTML
      {
         alert(result)
         $('.row').html(result)
      }
      
   })
})
</script>
</head>
<body>
  <div class="container">
   <div class="row">
   
   </div>
  </div>
</body>
</html>