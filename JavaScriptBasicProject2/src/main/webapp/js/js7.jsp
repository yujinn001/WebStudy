<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	send(callback);
}
// Callback 함수 => 매개변수로 전달되는 함수 , 시스템에 의해 자동 호출 => main, window.onload
function send(callback) // Redux => 매개변수로 함수를 전송할 수 있다 (함수도 데이터형으로 인식)
{
	for(let i =1; i<=10; i++)
	{
		callback();
	}
}

function callback()
{
	document.write("callback Call..");
}
</script>
</head>
<body>

</body>
</html>