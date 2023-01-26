<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   width: 350px;
   margin: 0px auto;
}
</style>
<script type="text/javascript">
window.onload= function(){
	const sawons=[
		{sabun:1,name:"홍길동",age:20,dept:"영업부",pay:3500},
		{sabun:2,name:"홍길동",age:20,dept:"영업부",pay:3500},
		{sabun:3,name:"홍길동",age:20,dept:"영업부",pay:3500},
		{sabun:4,name:"홍길동",age:20,dept:"영업부",pay:3500},
		{sabun:5,name:"홍길동",age:20,dept:"영업부",pay:3500},
		{sabun:6,name:"홍길동",age:20,dept:"영업부",pay:3500}
		
	]
	let html='';
	for(let sa of sawons)
	{
		html ='<tr>'
		+'<td class="text-center">'+sa.sabun+'</td>'
		+'<td class="text-center">'+sa.name+'</td>'
		+'<td class="text-center">'+sa.dept+'</td>'
		+'<td class="text-center">'+sa.pqy+'</td>'
		+'</tr>'
	}
	document.querySelector('tbody').innerHTML=html;
	
}
</script>
</head>
<body>
	<div class="container">
	 <div class="row">
	  <table class="table">
	  <thead>
	    <tr class="danger">
	     <th class="text-center">사번</th>
	     <th class="text-center">이름</th>
	     <th class="text-center">부서</th>
	     <th class="text-center">급여</th>
	    </tr>
	    </thead>
	    <tbody>
	    
	    </tbody>
	  </table>
	 </div>
	
	</div>
</body>
</html>