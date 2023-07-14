<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

<style type="text/css">
.center{
	margin: auto;
	width: 400px;
	border: 1px solid #a1a1a1;
	padding: 10px;
	/* background: #efefef; */
	border-radius: 30px;
}
</style>

</head>
<body>

<h2>login</h2>

<div class="center">

<form action="loginAf.do" method="post">
<br>
<table class="table">
<tr>
	<th>아이디</th>
	<td>
		<input type="text" class="form-control" id="id" name="id" size="20">	
	</td>
</tr>
<tr>
	<th>패스워드</th>
	<td>
		<input type="password" class="form-control" name="pwd" value="" size="20">
	</td>
</tr>
<tr>
	<td colspan="2">
		<div align="center">
			<input type="checkbox" id="chk_save_id">&nbsp;&nbsp;id 저장<br>
			<br>
			<span><input type="submit" class="btn btn-primary" value="login"></span>&nbsp;&nbsp;&nbsp;&nbsp;
			<span><a href="regi.do">회원가입</a></span>
		</div>
	</td>
</tr>

</table>

</form>

</div>

<script type="text/javascript">
/*
	session : server에 저장. login 정보.	Object
	cookie : client에 저장. id를 저장. pw 저장	String 
*/

let user_id = $.cookie("user_id");
if(user_id != null){	// 저장한 아이디가 있음
	$("#id").val( user_id );
	$("#chk_save_id").prop("checked", true);	// 첵크박스에 첵크가 되게 해준다
}

$("#chk_save_id").click(function(){
	// alert('click');
	// alert( $("#chk_save_id").is(":checked") );
	
	if( $("#chk_save_id").is(":checked") == true ){	// id를 저장 -> cookie
		
		if( $("#id").val().trim() == "" ){	// 빈문자열이었을 경우
			alert('id를 입력해 주십시오');
			$("#chk_save_id").prop("checked", false);
		}else{	
			// cookie 저장
			$.cookie("user_id", $("#id").val().trim(), { expires:7, path:'./' });
		}		
		
	}else{	// cookie에 저장하지 않음(삭제)
		
		$.removeCookie("user_id", { path:'./' });
	}
	
});

</script>


</body>
</html>










