<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear">
  <h2 class="sectiontitle">공지사항 등록</h2>
  <div style="height: 5px"></div>
  <form method="post" action="../adminpage/notice_insert_ok.do">
  <table class="table">
    <tr>
      <th width=15% class="text-right">구분</th>
      <td width=80%>
        <select name="type" class="input-sm">
          <option value="1">일반공지</option>
          <option value="2">이벤트공지</option>
          <option value="3">맛집공지</option>
          <option value="4">여행공지</option>
          <option value="5">상품공지</option>
        </select>
      </td>
    </tr>
    <tr>
      <th width=15% class="text-right">이름</th>
      <td width=80%>
        <input type=text name=name size=20 class="input-sm" readonly value="관리자">
      </td>
    </tr>
    <tr>
      <th width=15% class="text-right">제목</th>
      <td width=80%>
        <input type=text name=subject size=60 class="input-sm">
      </td>
    </tr>
    <tr>
      <th width=15% class="text-right">내용</th>
      <td width=80%>
        <textarea rows="10" cols="60" name="content"></textarea>
      </td>
    </tr>
    <tr>
      <th width=15% class="text-right">비밀번호</th>
      <td width=80%>
        <input type=password name=pwd size=15 class="input-sm">
      </td>
    </tr>
    <tr>
      <td colspan="2" class="text-center">
        <input type=submit value="글쓰기" class="btn btn-sm btn-danger">
        <input type=button value="취소" class="btn btn-sm btn-danger" onclick="javascript:history.back()">
      </td>
    </tr>
  </table>
  </form>
  </main>
</div>
</body>
</html>