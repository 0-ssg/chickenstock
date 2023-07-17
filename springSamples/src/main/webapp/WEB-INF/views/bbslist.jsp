<%@page import="ssg.com.a.dto.MemberDto"%>
<%@page import="ssg.com.a.dto.BbsParam"%>
<%@page import="util.BbsUtil"%>
<%@page import="ssg.com.a.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="ssg.com.a.dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<BbsDto> list = (List)request.getAttribute("bbslist");
	int pageBbs = (Integer)request.getAttribute("pageBbs");
	
	BbsParam param = (BbsParam)request.getAttribute("param");
	int pageNumber = param.getPageNumber();
	String choice = param.getChoice();
	String search = param.getSearch();
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판목록</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script type="text/javascript" src="jquery/jquery.twbsPagination.min.js"></script>
<!-- https://github.com/josecebe/twbs-pagination -->



<style type="text/css">
.center{
	margin: auto;
	width: 1000px;
	text-align: center;
}
th{
	background: royalblue;
	color: white;
} 
tr {
   line-height: 12px;   
}
</style>

</head>
<body>

<h1>게시판</h1>
<br>
<a href="pdslist.do">자료실</a>
<!-- <a href="calendarList.jsp">일정관리</a> -->

<%
MemberDto login = (MemberDto)session.getAttribute("login");
System.out.println(login.toString());
if(login != null){
	%>
	<a href="member?param=logout">login</a>
	<%
	}
%>

<div class="center">

<table class="table table-hover">
<col width="70"><col width="600"><col width="100"><col width="150">
<thead>
<tr>
	<th>번호</th><th>제목</th><th>조회수</th><th>작성자</th>
</tr>
</thead>

<tbody>
<%
if(list == null || list.size() == 0){
	%>
	<tr>
		<td colspan="4">작성된 글이 없습니다</td>
	</tr>
	<%
}else{
	
	for(int i = 0;i < list.size(); i++){
		BbsDto bbs = list.get(i);
		%>
		<tr>
			<td><%=i + 1 %></td>
			
			<%
			if(bbs.getDel() == 0){
				%>				
				<td style="text-align: left;">
					<a href="bbsdetail.do?seq=<%=bbs.getSeq() %>">
						<%=BbsUtil.arrow(bbs.getDepth()) %>
						<%=BbsUtil.titleDot(bbs.getTitle()) %>
					</a>
				</td>
				<% 
			}else{
			%>
				<td style="text-align: left;">
					<%=BbsUtil.arrow(bbs.getDepth()) %>
					<font color="#ff0000"> ****** 이 글은 작성자에 의해서 삭제되었습니다</font>
				</td>			
			<%
			}
			%>
			
			<td><%=bbs.getReadcount() %></td>
			<td><%=bbs.getId() %></td>
		</tr>
		<% 
	}
}
%>
</tbody>

</table>



<%--
	for(int i = 0;i < pageBbs; i++){	// 0 1 2 3 ~
		if(pageNumber == i){	// 현재 페이지
			%>
			<span style="font-size: 15pt;color: blue;font-weight: bold;">
				<%=i + 1 %>
			</span>			
			<%
		}
		else{	// 그밖에 페이지
			%>
			<a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>)"
				style="font-size: 15pt;color: #000; font-weight: bold; text-decoration: none;">
				[<%=i + 1 %>]
			</a>			
			<%
		}		
	}
--%>
<br>
<div class="container">
    <nav aria-label="Page navigation">
        <ul class="pagination" id="pagination" style="justify-content:center"></ul>
    </nav>
</div>

<br><br>
<div class="form-row align-items-center d-flex justify-content-center align-items-center container">
<select id="choice" class="form-control" style="width:auto;">
	<option value="">검색</option>
	<option value="title">제목</option>
	<option value="content">내용</option>
	<option value="writer">작성자</option>
</select>

<div class="col-sm-3 my-1" style="width:auto;">
	<input type="text" id="search" class="form-control" value="<%=search %>">
</div>

<button type="button" onclick="searchBtn()" class="btn btn-primary">검색</button>
</div>

<br><br>
<a href="bbswrite.do">글쓰기</a>

</div>

<script type="text/javascript">

// Java -> JavaScript
let search = "<%=search %>"; 	// 문자열일 경우
if(search != ""){
	let obj = document.getElementById("choice");
	obj.value = "<%=choice %>";
	obj.setAttribute("selected", "selected");
} 

function searchBtn() {

	let choice = document.getElementById("choice").value;
//	let choice = $("#choice").val();
	let search = document.getElementById("search").value;
	/*
	if(choice.trim() == ""){
		alert("카테고리를 선택해 주십시오");
		return;
	}
	if(search.trim() == ""){
		alert("검색어를 입력해 주십시오");
		return;
	}
	*/
	location.href = "bbslist.do?choice=" + choice + "&search=" + search;
}
/*
function goPage( pageNum ) {
	let choice = $("#choice").val();
	let search = $("#search").val();

	location.href = "bbslist.do?choice=" + choice + "&search=" + search + "&pageNumber=" + pageNum;
}
*/

$("#pagination").twbsPagination({
	startPage: <%=pageNumber+1 %>,
	totalPages: <%=pageBbs %>,
	visiblePages: 10,
	first: '<span srid-hidden="true">«</span>',	// 처음 페이지로 이동
	prev: "이전",
	next: "다음",
	last: '<span srid-hidden="true">»</span>',
	initiateStartPageClick: false,	// onPageClick의 페이지 시작시 자동으로 실행되는 문제 해결
	onPageClick:function(event,page){	// 페이지 클릭 시 실행
		let choice = $("#choice").val();
		let search = $("#search").val();

		location.href = "bbslist.do?choice=" + choice 
						+ "&search=" + search 
						+ "&pageNumber=" + (page-1);
	}
})

</script>


</body>
</html>











