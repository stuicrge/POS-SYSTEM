package com.example.demo.dao;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.example.demo.dto.Stock;

public class StockDao {
	
	private JdbcTemplate jdbcTemplate;
	public StockDao(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
		}
	
	// 출력할 재고 리스트 메소드 selectAll()
	public List<Stock> selectAll() {
		List<Stock> results = jdbcTemplate.query("select * from STOCK",
		(ResultSet rs, int rowNum) -> {
			Stock stock = new Stock( rs.getString("stockCode"), rs.getString("stockName"),
					rs.getInt("stockPrice"), rs.getInt("stocks"),rs.getTimestamp("registerDatetime").toLocalDateTime());
			stock.setId(rs.getLong("ID"));
			return stock;
});
		return results;
}
	// 코드를 통해 결과값을 구별하는 메소드
	public Stock selectByCode(String code) {
		List<Stock> results = jdbcTemplate.query("select * from STOCK where stockCode = ?",new RowMapper<Stock>() {
			@Override 
			public Stock mapRow(ResultSet rs, int rowNum)  throws SQLException{
				Stock stock= new Stock(  
						rs.getString("stockCode"), rs.getString("stockName"),
						rs.getInt("stockPrice"), rs.getInt("stocks"),rs.getTimestamp("registerDatetime").toLocalDateTime());
				stock.setId(rs.getLong("ID"));
						return stock;
				}}, code);
		return results.isEmpty() ? null : results.get(0);
		}
	
	// 새로운 제품을 추가하는 메소드
	public void insert(Stock stock) {	
	    KeyHolder keyHolder = new GeneratedKeyHolder();
	    jdbcTemplate.update(
	    		new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement pstmt = con.prepareStatement(
	    						"insert into STOCK (stockCode, stockName, stockPrice, stocks, registerDatetime) values(?, ?, ?, ?, ?)",
	    						new String[] {"ID"} );
	    						pstmt.setString(1,  stock.getStockCode());
	    						pstmt.setString(2, stock.getStockName());
	    						pstmt.setInt(3, stock.getStockPrice());
	    						pstmt.setInt(4, stock.getStocks());
	    						pstmt.setDate(5, new java.sql.Date(Timestamp.valueOf(stock.getRegisterDateTime()).getTime()));
	    						return pstmt;
					}	    			
	    		},   		
	    		keyHolder);
	    Number keyValue = keyHolder.getKey();
	    stock.setId(keyValue.longValue());
	}
	
	//현재 재고 상태
	public int nowStock(String stockCode) {
		String sql ="select stocks from STOCK where stockCode = ?";
		return this.jdbcTemplate.queryForObject (sql, Integer.class, stockCode);
	}
	
	// 기존의 있던 제품을 추가 입고
	public void addStocks(String stockCode, int stocks) {
			String sql = "update STOCK set stocks = ?, registerDatetime = ?  where stockCode = ?";
			int currentstocks = nowStock(stockCode);
			currentstocks += stocks;				
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			Date now = new Date();
			this.jdbcTemplate.update(sql,currentstocks, s.format(now),stockCode);
		}
	
	// 제품의 가격 재고 상태를 바꿈
	public void updateStocks(Stock stock) {
		jdbcTemplate.update("update STOCK set stockPrice = ?, stocks = ? where stockCode = ?",
				stock.getStockPrice(), stock.getStocks(), stock.getStockCode());
	}
	
	// 제품 삭제
	public void deleteStocks(Long id) {
		jdbcTemplate.update("delete from stock where id = ?", id);
	}
}
