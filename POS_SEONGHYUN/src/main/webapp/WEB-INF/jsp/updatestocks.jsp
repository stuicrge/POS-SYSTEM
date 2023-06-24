<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<title>제품 수정</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="row d-flex justify-content-center" style="margin-top: 10%">
	<form action="/stock/updateComplete" method="post" align="center"> 
		<p> <label>제품수량:<br><input type="text" name="stocks" id="stocks" required></label> </p>
		<p> <label>제품코드:<br><input type="text" name="stockCode" id="stockCode" required></label> </p>
		<p> <label>제품가격:<br><input type="text" name="stockPrice" id="stockPrice" required></label> </p>
		<input class="btn btn-dark" type="submit" value="수정하기">
	</form>
</div>
</body>
</html>