package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.SaleDao;
import com.example.demo.dto.Sale;

public class SaleService {

	
	private SaleDao saleDao;
	public SaleService(SaleDao saleDao) {
		this.saleDao= saleDao;
	}
	// 판매내역에 삽입
	public void insert(String[] name, int[] count, int[] price, String type) {
		saleDao.insert(name, count, price, type);
	}
	
	//판매 재고들 업데이트
	public void updateCount(String[] name, int[] count) {
		saleDao.updateCount(name, count);
	}
	
	// 판매내역 리스트
	public List<Sale> saleHistory() {
		return saleDao.saleHistory();
	}
	public List<Sale> allSaleList() {
		return saleDao.saleHistory();
	}
	public List<Sale> DaySaleList(){
		return saleDao.selectByDay();
	}
	public List<Sale> WeekSaleList(){
		return saleDao.selectByWeek();
	}
	public List<Sale> MonthSaleList(){
		return saleDao.selectByMonth();
	}
	public List<Sale> BestSaleList(){
		return saleDao.selectByBest();
	}
	public int DaySum() {
		return saleDao.DaySum();
	}
	public int WeekSum() {
		return saleDao.WeekSum();
	}
	public int MonthSum() {
		return saleDao.MonthSum();
	}
	
}
