package com.example.demo.service;
import java.time.LocalDateTime;
import java.util.List;
import com.example.demo.dao.StockDao;
import com.example.demo.dto.Stock;
public class StockService {
	
		private StockDao stockDao;
		public StockService(StockDao stockDao) {
			this.stockDao= stockDao;
			}
		
		//제품등록및 추가서비스
		public Long regist(Stock add) throws Exception {
			
			Stock newStock= new Stock( add.getStockCode(), add.getStockName(), add.getStockPrice(),add.getStocks(), LocalDateTime.now());
			stockDao.insert(newStock);
			return newStock.getId();	
		}
		//제품 리스트 출력 서비스
		public List<Stock> allStockList() {		
			return stockDao.selectAll();
		}
		
		//제품 입고하기 서비스
		public void plusStocks(String stockCode, int stocks) {
			stockDao.addStocks(stockCode, stocks);
		}
		
		// 제품 수정하기 서비스
		public void update(Stock stock) {
			stockDao.updateStocks(stock);
		}
		
		// 제품 삭제하기 서비스
		public void delete(Long id) {
			stockDao.deleteStocks(id);
		}
		
	}

