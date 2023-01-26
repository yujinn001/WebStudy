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
        margin-top:30px;
     }
     .row{
     width: 800px;
     margin: 0px auto;
     }
  </style>
<script type="text/javascript">
let calc=()=>{
	let price =document.querySelector("#price").getAttribute("value"); //$("#price").attr("value")
	// 태그의 속성값 읽기
	let count =document.querySelector("#count").value;
	//alert("count="+count)
	let total =price*Number(count);
	document.querySelector("#total").innerText=total;
	// 태그 사이에 값을 첨부
}
</script>
</head>
<body>
	<div class="container">
	 <div class="row">
	  <table class="table">
	    <tr>
	     <td width =30% class="text-center" rowspan="7">
	       <img src ="https://recipe1.ezmember.co.kr/cache/data/goods/22/11/48/1000032118/1000032118_detail_094.jpg" style="width:300px; height=350px">
	      </td>
	      <td width  =70%><h3>[만개특가] 전통 수타방식 사누끼우동 면10인분+가쓰오 소스10개</h3><sub style="color:gray">따뜻하고 얼큰한 맛이 일품!</sub></td>
	      
	    </tr>
	    <tr>
	      <td colspan="2">
	        <h3> <span style="color:magenta">46%</span>&nbsp;&nbsp;10,700원</h3>
	        <sub style="color:gray">19,900원</sub>
	      </td>
	    </tr>
	    <tr>
	      <td colspan="2">
	       <span style="color:green">첫 구매 할인가 &nbsp; &nbsp; 10,165원</span>
	      </td>
	    </tr>
	    <tr>
	     <td colspan="2">
	      배송: 무료 배송
	     </td>
	    </tr>
	    <tr>
	     <td colspan="2">
	      적립 54원 적립 (모든 회원 구매액의 0.5% 적립)
	      </td>
	    </tr>
	    <tr>
	      <td width=30%>
	       <span id="price" >10700</span>
	      </td>
	      <td width =405>
	       <select id="count" class="input-sm" onchange="calc()">
	         <option selected value="1">1개</option>
	         <option value="2">2개</option>
	         <option value="3">3개</option>
	         <option value="4">4개</option>
	         <option value="5">5개</option>
	       </select>
	      </td>
	    </tr>
	    <tr>
	     <td colspan="2" class="text-right">
	      주문 금액&nbsp;<input type="text" style="color:green;font-size:20px" id="total">&nbsp;원
	     </td>
	     
	    </tr>
	  </table>
	 </div>
	</div>
</body>
</html>


















