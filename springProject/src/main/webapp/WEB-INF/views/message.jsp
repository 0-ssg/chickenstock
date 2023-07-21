<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String login = (String)request.getAttribute("loginmsg");
if(login != null && login.equals("") == false){
	if(login.equals("LOGIN_NO")){		
		%>
		<script>
		alert("아이디나 비밀번호를 확인해 주십시오");
		location.href = "login.do";
		</script>
		<%	
	}else{
		%>
		<script>
		alert("홈페이지 방문을 환영합니다");
		location.href = "home.do";
		</script>
		<%
	}
}

String bbswrite = (String)request.getAttribute("newswrite");
if(bbswrite != null && !bbswrite.equals("")){
	if(bbswrite.equals("BBS_ADD_OK")){
		%>
		<script type="text/javascript">
		alert("성공적으로 작성되었습니다");
		location.href = "bbslist.do";
		</script>
		<%
	}
	else{
		%>
		<script type="text/javascript">
		alert("다시 작성해 주십시오");
		location.href = "bbswrite.do";
		</script>
		<%
	}
}

String bbsupdate = (String)request.getAttribute("newsupdate");
if(bbsupdate != null && bbsupdate.equals("") == false){
	if(bbsupdate.equals("BBSUPDATE_YES")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		%>
		<script>
		alert("수정되었습니다.");
		location.href = "bbsdetail.do?seq=" + <%= seq %>;
		</script>
		<%
	}else if(bbsupdate.equals("BBSUPDATE_NO")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		%>
		<script>
		alert("수정 실패했습니다.");
		location.href = "bbsdetail.do?seq=" +<%= seq %>";
		</script>
		<%
	}
}
String bbsdelete = (String)request.getAttribute("newsdelete");
if(bbsdelete != null && bbsdelete.equals("") == false){
	if(bbsdelete.equals("BBSDELETE_YES")){

		%>
		<script>
	    alert('글 삭제 성공!');
	    location.href = "bbslist.do";
		</script>
		<%
	}else if(bbsdelete.equals("BBSDELETE_NO")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		%>
		<script>
	    alert('글 삭제 실패~');
	    location.href = "bbsdetail.do?seq=" + <%=seq %>;
		</script>
		<%		
	}
}

%>









