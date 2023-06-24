<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>매출</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<body>
	<div class="text-center">
		<jsp:include page="menu.jsp" />
		<div class="row justify-content-center">
			<div align="center" class="table">
				<div class="add-btn mb-4 mt-3">
					<button class="btn btn-dark" type="button" onclick="location.href='/sales/daysales'">하루 매출액</button>
					<button class="btn btn-dark" type="button" onclick="location.href='/sales/weeksales'">일주일 매출액</button>
					<button class="btn btn-dark" type="button" onclick="location.href='/sales/monthsales'">한달 매출액</button>
					<button class="btn btn-dark" type="button" onclick="location.href='/sales/bestsales'">Best 상품</button>
				</div>
				<div>
					<table border="3" width="700px">
						<tr>
							<td>제품이름</td>
							<td>판매수량</td>
							<td>금액</td>
							<td>판매날짜</td>
						</tr>
						<c:forEach var="list" items="${saleList}">
							<tr>
								<td><c:out value="${list.name}"/> </td>
								<td><c:out value="${list.count}"/> </td>
								<td><c:out value="${list.price}"/></td>
								<td><c:out value="${list.soldDate}"/> </td>
							</tr>
						</c:forEach>
						<tr>
							<td>총액 </td>
							<td> </td>
							<td>${daysum}</td>
						<tr>						
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>