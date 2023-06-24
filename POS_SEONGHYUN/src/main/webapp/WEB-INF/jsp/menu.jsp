<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>menu</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
    <a href="/homepage" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none" style="color: black"><h2>POS</h2></a>
    	<a href="/sale" class="nav-link px-10" style="color: black">판매</a>
      	<a href="/stock" class="nav-link px-10" style="color: black">재고관리</a></li>
      	<c:if test="${user.userType == '관리자'}">
      	<a href="/sales" class="nav-link px-10" style="color: black">매출</a>
     	</c:if>	
    <div class="col-md-4 text-end" style="inline-block;">
      <a> ${user.userName}님 (${user.userType}) </a>
      <button type="button" class="btn btn-dark link-white"><a href="/logout" style="color: white">Log-out</a></button>
      <c:if test="${user.userType == '관리자'}">
      <button type="button" class="btn btn-dark link-dark"><a href="/changePassword" style="color: white">회원정보수정</a></button>
  	  </c:if>
    </div>
  </header>
</div>
</body>
</html>