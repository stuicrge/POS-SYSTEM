<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
 <title>회원가입</title> 
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</script>
</head>
<body>
<div class="row d-flex justify-content-center" style="margin-top: 10%">
	<form action="/regist" method="post" align="center">
		<h2>회원정보입력</h2>
		<p> <label>아이디:<br><input type="text" name="userId" id="userId"></label> </p>
		<p> <label>이메일:<br><input type="text" name="userEmail" id="userEmail"></label> </p>
		<p> <label>이름:<br><input type="text" name="userName" id="userName"></label> </p>
		<div class="row d-flex justify-content-center">
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="userType" value="직원" id="userType">
			  <label class="form-check-label" for="userType">직원</label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="userType" value="관리자" id="userType" checked>
			  <label class="form-check-label" for="userType">관리자</label>
			</div>
		</div>
		
		<p> <label>비밀번호:<br><input type="password" name="userPw" id="userPw"></label> </p>
		<p> <label>비밀번호확인:<br><input type="password" name="confirmPassword" id="confirmPassword"></label> </p>
		<input class="btn btn-dark" type="submit" value="가입하기">
	</form>
</div>
</body>
</html>