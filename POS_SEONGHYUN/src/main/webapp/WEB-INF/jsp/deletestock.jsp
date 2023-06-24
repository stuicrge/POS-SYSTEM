<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<title>제품삭제</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="row d-flex justify-content-center" style="margin-top: 10%">
	<form action="/stock/deleteComplete" method="post" align="center">
		<p> <label>제품아이디:<br><input type="text" name="id" id="id" required></label> </p>
		<input class="btn btn-dark" type="submit" value="삭제하기">
	</form>
</div>
</body>
</html>