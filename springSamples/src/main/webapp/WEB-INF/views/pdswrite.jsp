<%@page import="ssg.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberDto login = (MemberDto)session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdswrite</title>
</head>
<body>

<h1>자료올리기(upload)</h1>
<br>

<div align="center">

<form action="pdsupload.do" method="post" enctype="multipart/form-data">

<table border="1">
<tr>
	<th>아이디</th>
	<td>
		<input type="text" name="id" value="<%=login.getId()%>" readonly="readonly">
	</td>
</tr>
<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" size="50">
	</td>
</tr>
<tr>
	<th>파일업로드</th>
	<td>
		<input type="file" name="fileupload">
	</td>
</tr>
<tr>
	<th>내용</th>
	<td>
		<textarea rows="10" cols="50" name="content"></textarea>
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="자료올리기">
	</td>
</tr>
</table>

</form>

</div>
</body>
</html>










