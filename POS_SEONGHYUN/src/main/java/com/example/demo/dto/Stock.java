package com.example.demo.dto;
import java.time.LocalDateTime;
public class Stock {
	private Long id; // prkey를 위한 id
	private String stockCode; //제품코드
	private String stockName;// 제품이름
	private int stockPrice;// 제품가격
	private int stocks; // 제품재고
	private LocalDateTime registerDateTime; //등록시간
	
	
	
	
	public Stock(String stockCode, String stockName, int stockPrice, int stocks, LocalDateTime regDateTime) {
		this.stockCode= stockCode;
		this.stockName= stockName;
		this.stockPrice = stockPrice;
		this.stocks = stocks;
		this.registerDateTime= regDateTime;
		}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStockCode() {
		return stockCode;
	}



	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}



	public String getStockName() {
		return stockName;
	}



	public void setStockName(String stockName) {
		this.stockName = stockName;
	}



	public int getStockPrice() {
		return stockPrice;
	}



	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}


	public int getStocks() {
		return stocks;
	}



	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}
	
	public void setRegisterDateTime(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}

}