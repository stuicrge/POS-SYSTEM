<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Main</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div>
<div class="row d-flex justify-content-center" style="margin-top: 10%">
	<form action="homepage" method="post" align="center">
		<h1>포스기</h1>
		<p> <label>아이디:<br><input type="text" name="userId" id="userId" value="${registerRequest.userId}"></label> </p>
	 	<p> <label>비밀번호:<br><input type="password" name="userPw" id="userPw"  value="${registerRequest.userPw}" ></label> </p>
	
	 	<div class="d-grid gap-2 col-1 mx-auto">
		 	<input class="btn btn-dark" type="submit" value="로그인">
		 	<a href="userjoin" class="btn btn-dark">회원가입</a>
	 	</div>
	 </form>
</div>
</body>
</html>