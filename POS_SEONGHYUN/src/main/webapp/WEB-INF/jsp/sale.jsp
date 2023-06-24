<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>판매</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="/js/sale.js"></script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="main">
	<div class="container">
		<div class="row">
			<div class="col-6">
				<div class="stock_div mt-3">
					<c:forEach var="list" items="${stockList}">
						<button class="btn btn-outline-dark" type="button"  onclick="btnOnclick('${list.stockName}', ${list.stockPrice})" value="${list.stockName}">
							<c:out value="${list.stockName}"/>
							<br>	
							<c:out value="현재 개수: ${list.stocks}" />
						</button>
					</c:forEach>
				</div>
			</div>
			
			<div class="col-6">
				<div class="table-div mt-3">
					<table class="table" >
						<thead>
							<tr>
								<td><b>제품이름</b></td>
								<td><b>제품수량</b></td>
								<td><b>금액</b></td>						
							</tr>
						</thead>
						<tbody id="table-body">
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="row">			
			<div class="col-6 mt-2">
				<div class="row">
					<div class="col-3 mt-2" >
						<label class="col-form-label"><h4>총금액</h4></label>
					</div>
					<div class="col-9 mt-2">
						<label type="text" class="total-label form-control" id="totalLabel" readonly> 0</label>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-6 mt-2">
				<div class="mt-3">
					<button class="btn-list btn btn-dark"  type="button" onclick="location.href='/sale/saleHistory'">판매내역</button>
					<button class="btn-list btn btn-dark" type="button" name="card" id="card" >카드결제</button> 
					<button class="btn-list btn btn-dark" type="button" name="cash" id="cash">현금결제</button>
					<button class="btn-list btn btn-dark" type="button" id="cancel" onclick="cancel()">전체취소</button>
				</div>
			</div>
		</div>
	</div>
</div>	
	
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 
	
	<!-- cash -->
	<script>
	$(function(){
		$("#cash").click(function() {
			let type="현금결제";
			let table = document.getElementById('table-body');
			let name = []
			let count = []
			let price = []
			
			for(let i=0; i < table.rows.length; i++) {
				name.push(table.rows[i].cells[0].innerHTML)
				count.push(table.rows[i].cells[1].innerHTML) 
				price.push(table.rows[i].cells[2].innerHTML) 
			} 	
			$.ajax({
				type: "POST",
				data: { name : name, count : count, price : price, type : type },
				url: "/sale/pay"
			});
		});
	});
	</script>
		
	<script>
	$(function(){
		$("#card").click(function() {
			let type="카드결제";
			let table = document.getElementById('table-body');
			let name = []
			let count = []
			let price = []			
			
			for(let i=0; i < table.rows.length; i++) {
				name.push(table.rows[i].cells[0].innerHTML)
				count.push(table.rows[i].cells[1].innerHTML) 
				price.push(table.rows[i].cells[2].innerHTML) 
			} 
			$.ajax({
				type: "POST",
				data: { name : name, count : count, price : price, type : type },
				url: "/sale/pay"
				
			});
		});
	});
	</script>
</body>
</html>