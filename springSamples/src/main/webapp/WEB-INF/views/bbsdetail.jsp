<%@page import="ssg.com.a.dto.MemberDto"%>
<%@page import="ssg.com.a.dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberDto mem = (MemberDto)session.getAttribute("login");
	BbsDto dto = (BbsDto)request.getAttribute("bbsdto");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 글보기</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
.center{
	margin: auto;
	width: 800px;		
}
th{
	background: royalblue;
	color: white;
}
</style>

</head>
<body>

<h1>상세 글보기</h1>

<div class="center">

<table class="table table-bordered">
<col width="200"><col width="500">

<tr>
	<th>작성자</th>
	<td><%=dto.getId() %></td>	
</tr>
<tr>
	<th>작성일</th>
	<td><%=dto.getWdate() %></td>	
</tr>
<tr>
	<th>조회수</th>
	<td><%=dto.getReadcount() %></td>	
</tr>
<tr>
	<th>제목</th>
	<td><%=dto.getTitle() %></td>	
</tr>
<tr>	
	<td colspan="2" style="height: 300px; font-size: 120%"><%=dto.getContent() %></td>
</tr>
</table>

<br>

<button type="button" onclick="answerBbs(<%=dto.getSeq() %>)">답글</button>

<button type="button" onclick="updateBbs(<%=dto.getSeq() %>)">글수정</button>

<button type="button" onclick="deleteBbs(<%=dto.getSeq() %>)">글삭제</button>

<script type="text/javascript">
function answerBbs( seq ) {
	location.href = "bbs?param=answer&seq=" + seq;	
}
function updateBbs(seq) {
    location.href = "bbsupdate.do?seq=" + seq;
}

function deleteBbs(seq) {
    location.href = "bbs?param=bbsdelete&seq=" + seq;
}

</script>


</div>

</body>
</html>







