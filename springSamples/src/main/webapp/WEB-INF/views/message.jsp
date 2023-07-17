<%@page import="ssg.com.a.dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String message = (String)request.getAttribute("message");

if(message != null && message.equals("")== false){
	if(message.equals("MEMBER_YES")){
		%>
		<script>
		alert("성공적으로 가입되었습니다");
		location.href = "login.do";
		</script>
		<%
	}else if(message.equals("MEMBER_NO")){
		%>
		<script>
		alert("가입되지 않았습니다. 다시 가입해 주세요");
		location.href = "regi.do"
		</script>
		<%
	}
}

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
		location.href = "bbslist.do";
		</script>
		<%	
	}
}

String bbswrite = (String)request.getAttribute("bbswrite");
if(bbswrite != null && bbswrite.equals("") == false){
	if(bbswrite.equals("BBSWRITE_YES")){
		%>
		<script>
		alert("글이 추가되었습니다");
		location.href = "bbslist.do";
		</script>	
		<%
	}else if(message.equals("BBSWRITE_NO")){
		%>
		<script>
		alert("다시 작성해 주십시오");
		location.href = "bbslist.do";
		</script>
		<%
	}
}												
String bbsupdate = (String)request.getAttribute("bbsupdate");
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

String bbsanswer = (String)request.getAttribute("bbsanswer");
if(bbsanswer != null && bbsanswer.equals("") == false){
	if(bbsanswer.equals("BBSANSWER_YES")){
		%>
		<script>
		alert('답글입력 성공!');
		location.href = "bbslist.do";
		</script>
		<%
	}else if(bbsanswer.equals("BBSANSWER_NO")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		%>
		<script>
		alert('답글입력 실패~');
		location.href = "bbsanswer.do?seq=" + <%=seq %>;
		</script>	
		<%
	}
}
%>
<%
if(false){
	
	if(message.equals("BBSANSWER_YES")){
		%>
		<script>
		alert('답글입력 성공!');
		location.href = "bbs?param=bbslist";
		</script>
		<%
	}else if(message.equals("BBSANSWER_NO")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		%>
		<script>
		alert('답글입력 실패~');
		location.href = "bbs?param=answer&seq=" + <%=seq %>;
		</script>	
		<%
	}
	
	if(message.equals("BBSUPDATE_YES")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		%>
		<script>
		alert("수정되었습니다.");
		location.href = "bbs?param=bbslist&seq=" + <%= seq %>;
		</script>
		<%
	}else if(message.equals("BBSUPDATE_NO")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		%>
		<script>
		alert("수정 실패했습니다.");
		location.href = "bbs?param=bbslist&seq=" +<%= seq %>";
		</script>
		<%
	}
	
	if(message.equals("BBSDELETE_YES")){

		%>
		<script>
	    alert('글 삭제 성공!');
	    location.href = "bbs?param=bbslist";
		</script>
		<%
	}else if(message.equals("BBSDELETE_NO")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		%>
		<script>
	    alert('글 삭제 실패~');
	    location.href = "bbs?param=bbsdetail&seq=" + <%=seq %>;
		</script>
		<%		
	}
	
	if(message.equals("CALWRITE_YES")){
		%>
		<script>
		alert('일정이 추가되었습니다');
		location.href = "cal?param=calendarList"
		</script>
		<%
	}else if(message.equals("CALWRITE_NO")){
		%>
		<script>
		alert('추가되지 않았습니다');
		location.href = "cal?param=calendarList"
		</script>
		<%
	}
	
	if(message.equals("CALUPDATE_FAIL")){
		%>
		<script>
		alert('일정을 불러오는데 실패했습니다');
		location.href = "cal?param=calendarList"
		</script>
		<%
	}else if(message.equals("CALUPDATE_YES")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		%>    
		<script type="text/javascript">
		alert('성공적으로 수정되었습니다');
		location.href = "cal?param=caldetail&seq=" + "<%=seq %>";
		</script>
		<%
	}else if(message.equals("CALUPDATE_NO")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		%>
		<script type="text/javascript">
		alert('수정되지 않았습니다');
		location.href = "cal?param=caldetail&seq=" + "<%=seq %>";
		</script>
		<%
	}
	if(message.equals("CALDELETE_YES")){
		%>     
		<script type="text/javascript">
		alert("삭제되었습니다");
		location.href = "cal?param=calendarList";
		</script>
		<%
	}else if(message.equals("CALDELETE_NO")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		%>
		<script type="text/javascript">
		alert("삭제되지 않았습니다");
		location.href = "cal?caldetail&seq=" + "<%=seq %>"; 
		</script>
		<%
	}
}
%>