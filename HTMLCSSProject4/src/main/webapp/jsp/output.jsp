<!-- CSS�� ��縸 �����ش� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// �ڹ� ����
	// request�� ���� �޴´�
	// setCharacterEncoding => �ѱ� ��ȯ => ȸ������
	request.setCharacterEncoding("UTF-8");
	String name =request.getParameter("name");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<b><%=name %></b>
</body>
</html>