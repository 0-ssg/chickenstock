<%@page import="ssg.com.a.dto.PdsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
List<PdsDto> list = (List<PdsDto>)request.getAttribute("pdslist");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdslist</title>
</head>
<body>

<h1>자료실 목록</h1>
<br>

<div align="center">

<table border="1">
<col width="50"><col width="100"><col width="300">
<col width="50"><col width="50"><col width="100">

<thead>
<tr>
	<th>번호</th><th>작성자</th><th>제목</th>
	<th>조회수</th><th>다운수</th><th>작성일</th>
</tr>
</thead>

<%
for(int i = 0; i < list.size(); i++){
	PdsDto pds = list.get(i);
	%>
	<tr>
		<th><%=(i + 1) %></th>
		<td><%=pds.getId() %></td>
		<td>
			<a href="pdsdetail.do?seq=<%=pds.getSeq() %>"><%=pds.getTitle() %></a>
		</td>
		<td><%=pds.getReadcount() %></td>
		<td><%=pds.getDowncount() %></td>
		<td><%=pds.getRegdate() %></td>
	</tr>
	<%
}	
%>
</table>

<br>
<a href="pdswrite.do">자료추가</a>
</div>
</body>
</html>










