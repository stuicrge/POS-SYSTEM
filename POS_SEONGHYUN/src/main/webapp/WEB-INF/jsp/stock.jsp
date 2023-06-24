<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
 <title>재고 관리</title> 
</head>
<body>
	<div class="text-center">
		<jsp:include page="menu.jsp" />
		<div class="row justify-content-center">
			<div align="center" class="table">
				<div class="add-btn mb-4 mt-3">
					<a class="btn btn-dark" href="stock/addstock">제품추가</a>
					<a class="btn btn-dark" href="stock/addstocks">제품입고</a>
					<a class="btn btn-dark" href="stock/updatestocks">제품수정</a>
					<a class="btn btn-dark" href="stock/deletestock">제품삭제</a>
				</div>
				<div>
					<table border="3" width="700px">
						<tr>
							<th>제품 코드</th>
							<th>제품명</th>
							<th>제품 가격</th>
							<th>수량</th>
							<th>등록 시간</th>
						</tr>
						<c:forEach var="list" items="${stockList}">
							<tr>
								<td><c:out value="${list.stockCode}"/> </td>
								<td><c:out value="${list.stockName}"/> </td>
								<td><c:out value="${list.stockPrice}"/></td>
								<td><c:out value="${list.stocks}"/> </td>
								<td><c:out value="${list.registerDateTime}"/> </td>
							</tr>
							</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>