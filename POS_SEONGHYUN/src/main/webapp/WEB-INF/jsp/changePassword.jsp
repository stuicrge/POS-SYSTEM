<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
 <title>회원가입</title> 
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="row d-flex justify-content-center" style="margin-top: 10%">
	<form action="/user/changePassword" method="post" align="center">
		<h2>회원정보입력</h2>
		<p> <label>아이디:<br><input type="text" name="userId" id="userId"></label> </p>	
		<p> <label>변경할 비밀번호를 입력하세요:<br><input type="password" name="userPw" id="userPw"></label> </p>
		<p> <label>변경된 비밀번호 확인:<br><input type="password" name="confirmPassword" id="confirmPassword"></label> </p>
		<input class="btn btn-dark" type="submit" value="비밀번호변경">
	</form>
</div>
</body>
</html>