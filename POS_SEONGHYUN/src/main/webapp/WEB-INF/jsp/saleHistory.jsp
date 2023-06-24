<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>판매 내역</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<body>
	<div class="text-center">
	<jsp:include page="menu.jsp" />
		<div align="center" class="table">
			<h3>판매 내역</h3>
			<p/>
			<table border="3" width="700px">
					<tr>
						<td>제품이름</td>
						<td>판매수량</td>
						<td>금액</td>
						<td>판매날짜</td>
						<td>결제수단</td>
					</tr>
					<c:forEach var="list" items="${saleList}">
						<tr>
							<td><c:out value="${list.name}"/> </td>
							<td><c:out value="${list.count}"/> </td>
							<td><c:out value="${list.price}"/></td>
							<td><c:out value="${list.soldDate}"/> </td>
							<td><c:out value="${list.type}"/> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>