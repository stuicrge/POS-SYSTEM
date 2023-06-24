package com.example.demo.dto;

public class Sale {
	private int count; // 판매 수
	private String name; // 판매 제품 이름
	private int price; // 판매 제품 가격
	private String soldDate; // 팔린 시기
	private String type; // 카드결제 or 현금결제
	
	// dao나 서비스에서 다양하게 사용하기 위해 sale()의 여러 형태를 만들어놓는다.
	
	public Sale() {
		
	} 
	
	public Sale( int count, String name, int price, String soldDate, String type) {
		this.count = count;
		this.name = name;
		this.price = price;
		this.soldDate = soldDate;
		this.type = type;
	}
	public Sale(String name, int count, int price) {
		this.name = name;
		this.count = count;
		this.price = price;
	}
	
	public Sale(String name, int count, int price, String soldDate) {
		this.name = name;
		this.count = count;
		this.price = price;
		this.soldDate = soldDate;
	}

	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(String soldDate) {
		this.soldDate = soldDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}