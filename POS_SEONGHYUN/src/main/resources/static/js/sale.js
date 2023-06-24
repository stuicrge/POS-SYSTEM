// stockList 버튼들을 클릭시 작동함
function btnOnclick(stockName, stockPrice) {
		let table = document.getElementById('table-body');
		let name;
	
		if(table.rows.length == 0) {
			let count = 1;
			let addRow = table.insertRow(table.rows.length);
			let cell1 = addRow.insertCell(0);
			let cell2 = addRow.insertCell(1);
			let cell3 = addRow.insertCell(2);
			cell1.innerHTML = stockName;
			cell2.innerHTML = count;
			cell3.innerHTML = stockPrice;
			totalTable();
			return;
		}
		
		// 중복클릭을 허용한다 (재고에서)
		for(var i=0; i < table.rows.length; i++) {
			name = table.rows[i].cells[0].innerHTML; 
			if(name == stockName) {
				let count = parseInt(table.rows[i].cells[1].innerHTML) + 1;
				table.rows[i].cells[1].innerHTML = count;
				table.rows[i].cells[2].innerHTML = stockPrice * count;
				totalTable();
				return;
			}
				
		}
		
		let count = 1;
		let addRow = table.insertRow(table.rows.length);
		let cell1 = addRow.insertCell(0);
		let cell2 = addRow.insertCell(1);
		let cell3 = addRow.insertCell(2);
		cell1.innerHTML = stockName;
		cell2.innerHTML = count;
		cell3.innerHTML = stockPrice;
		totalTable();
}
// 총 합
function totalTable(){
		let table = document.getElementById('table-body');
		let labelText = document.getElementById('totalLabel');
		let totalPrice = 0;
		
		if(table.rows.length == 0) {
			labelText.innerHTML = 0;
		}
		else {
			for(let i=0; i<table.rows.length; i++) {
				totalPrice += parseInt(table.rows[i].cells[2].innerHTML);
			}
			labelText.innerHTML = totalPrice;
		}
 }
// 결제중이던 제품들 모두 취소
function cancel() {
	let table = document.getElementById('table-body');
	let length = table.rows.length;
	let labelText = document.getElementById('totalLabel');
	
	for(let i=0; i<=length; i++) {
		table.deleteRow(-1);
	}	
	labelText.innerHTML = 0;
}