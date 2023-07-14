<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<style type="text/css">
.center{
	margin: auto;
	width: 60%;
	border: 3px solid #0000ff;
	padding: 10px;
}
</style>

</head>
<body>

<h2>회원가입</h2>
<p>환영합니다</p>

<div class="center">
		<!-- MemberController의 @PostMapping("regiAf.do")와 매칭해줌  -->
<form action="regiAf.do" method="post">


<table border="1">
<tr> <!-- 아래 아이디 ~ 이메일을 MemberDto객체로 묶어서 MemberController의 addMember() 함수로 보냄 -->
	<th>아이디</th>
	<td>
		<input type="text" name="id" id="id" size="20" placeholder="아이디">
		<input type="button" id="id_chk_btn" value="id확인"><br>
		<p id="idcheck" style="font-size: 8px"></p>		
	</td>
</tr>
<tr>
	<th>패스워드</th>
	<td>
		<input type="text" name="pwd" id="pwd" size="20">
	</td>
</tr>
<tr>
	<th>이름</th>
	<td>
		<input type="text" name="name" size="20">
	</td>
</tr>
<tr>
	<th>이메일</th>
	<td>
		<input type="text" name="email" size="20">
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="회원가입">
	</td>
</tr>
</table>

</form>
</div>

<script type="text/javascript">
$(document).ready(function(){
	
	$("#id_chk_btn").click(function(){
		
		// id의 규칙: 대소문자 + 특수문자 포함
		
		// id 글자의 갯수
		
		// id가 사용할 수있는지 없는지 -ajax
		$.ajax({
			url:"idcheck.do",
			type:"post",
			data:{ "id":$("#id").val() },
			success:function( answer ){
				//alert("success");
				//alert(JSON.stringify(answer));	//{"str", YES} or {"str", NO} 들어옴
				
				if(answer == "YES"){
					$("#idcheck").css("color", "#0000ff");
					$("#idcheck").text("사용할 수 있는 아이디입니다");
				}else{
					$("#idcheck").css("color", "#ff0000");
					$("#idcheck").text("사용중인 아이디입니다");
					$("#id").val("");
				}
				
			},
			error:function(){
				alert('error');
			}
		});
	});
	
});
</script>




</body>
</html>










