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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

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
	<td colspan="2" style="height: 300px; font-size: 120%">
		<textarea rows="12" readonly style="background-color: #ffffff; font-size: 20px" 
cols="15" class="form-control" ><%=dto.getContent() %></textarea>
	</td>
</tr>
</table>

<br>

<button type="button" onclick="answerBbs(<%=dto.getSeq() %>)">답글</button>

<%
if(mem.getId().equals(dto.getId())){
	%>
	<button type="button" onclick="updateBbs(<%=dto.getSeq() %>)">글수정</button>
	
	<button type="button" onclick="deleteBbs(<%=dto.getSeq() %>)">글삭제</button>
	<%
}
%>

<script type="text/javascript">
function answerBbs( seq ) {
	location.href = "bbsanswer.do?seq=" + seq;	
}
function updateBbs(seq) {
    location.href = "bbsupdate.do?seq=" + seq;
}

function deleteBbs(seq) {
    location.href = "bbs?param=bbsdelete&seq=" + seq;
}

</script>

<br><br>
<!-- 댓글 -->
<div id="app" class="container">
<form action="commentWriteAf.do" method="post">
<input type="hidden" name="seq" value="<%=dto.getSeq() %>">
<input type="hidden" name="id" value="<%=mem.getId() %>">

<table>
<col width="1500px"><col width="150px">
<tr>
	<td>comment</td>
	<td style="padding-left: 30px">올리기</td>
</tr>
<tr>
	<td>
		<textarea rows="3" class="form-control" name="content"></textarea>
	</td>
	<td style="padding-left: 30px ">
		<button type="submit" class="btn btn-primary btn-block p-4">완료</button>
	</td>
</tr>
</table>

</form>
<br><br>

<table class="table table-sm">
<col width="500"><col width="500">

<tbody id="tbody">
</tbody>

</table>

<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		url:"commentList.do",
		type:"get",
		data:{seq:<%=dto.getSeq() %>},
		success: function(list){
			/*
			alert('success');
			alert(JSON.stringify(list));
			*/
			/*
			for(i = 0; i < list.length; i++){
				list[i].seq
				list[i].content
			}
			*/
			
			// tbody 태그안의 값을 모두 초기화 후 다시 게시
			$("#tbody").html("");
			
			$.each(list, function(i, item){
				let str = "<tr class='table-info'>"
						+		"<td>작성자:" + item.id + "</td>"
						+		"<td>작성일:" + item.wdate + "</td>"
						+	"</tr>"
						+	"<tr>"
						+		"<td colspan='2'>" + item.content + "</td>"
						+	"</tr>";
				$("#tbody").append(str);
			});
		},
		error:function(){
			alert('error');
		}
		
	});
	
})
</script>
</body>
</html>
















