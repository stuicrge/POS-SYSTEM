<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Hello</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<style> 
  .homepage_img {
  width: 1100px;
  height: 690px;
  overflow: hidden;
  margin: 0 auto;
  }
  .img-fluid {
   	width: 100%;
    height: 100%;
	object-fit: cover;
  }
  .homepage_image_text {
    position: absolute;
    top: 20%;
    left: 50%;
    color: white;
  }
</style>
</head>
<body>	
 	<jsp:include page="menu.jsp" />
	<div class= "homepage_img">
	<img src="img/pos-machine-g6e9ef295e_1280.jpg" class="img-fluid" alt="">
	<h1 class="homepage_image_text" style="font-size:50px">The POS System</h1>
</div>		
</body>
</html>