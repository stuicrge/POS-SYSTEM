package com.example.demo.dao;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.example.demo.dto.Sale;

public class SaleDao {

	
private JdbcTemplate jdbcTemplate;
	
	public SaleDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 판매내역 삽입
	public void insert(String[] name, int[] count, int[] price, String type) {
		String sql = "insert into SALE(name, count, price, soldDate, type) values ( ?, ?, ?, ?, ?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date now = new Date();
		String soldDate = sdf.format(now);		
		for(int i=0; i<name.length; i++) {
			this.jdbcTemplate.update(sql, name[i], count[i], price[i], soldDate, type);
		}
	}
	
	//현재 재고 수량.
	public int getAmount(String name) {
		String sql = "select stocks from STOCK where stockName = ? ";
		return this.jdbcTemplate.queryForObject(sql,Integer.class, name);
	}
	// 재고 업데이트
	public void updateCount(String[] name, int[] count) {
		String sql = "update STOCK set stocks = ? where stockName =? ";
		
		for(int i=0; i<name.length; i++) {
			int current = getAmount(name[i]);
			current -= count[i];
			this.jdbcTemplate.update(sql,current,name[i]);
		}
	}

	//판매내역
	public List<Sale> saleHistory() {
		String sql = "select * from SALE order by soldDate DESC";
		List<Sale> results= this.jdbcTemplate.query(sql,
				new RowMapper<Sale>() {
			public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
                Sale sale = new Sale(
                		rs.getInt("count"),
                		rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("soldDate"),
                        rs.getString("type"));
                return sale;
            }
		});
		return results;
	}
	//하루 매출액
	public int DaySum() {
		String sql = "select sum(price * count) as 'sum' from sale where date(soldDate) = date(now())";
		return this.jdbcTemplate.queryForObject(sql,Integer.class);			
    }
	//하루 동안 팔린 제품 리스트
	public List<Sale> selectByDay() {
		List<Sale> results = null;
		String sql = "SELECT * FROM sale WHERE date(soldDate) = date(now())";
		results = this.jdbcTemplate.query(sql,
				new RowMapper<Sale>() {
			public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
                Sale sale = new Sale(
                		rs.getInt("count"),
                		rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("soldDate"),
                        rs.getString("type"));
                return sale;
            }
		});
		return results;
	}
	//일주일 매출액
	public int WeekSum() {
		String sql = "select sum(price * count) as 'sum' from sale where yearweek(soldDate) = yearweek(now())";
		return this.jdbcTemplate.queryForObject(sql,Integer.class);
		
    }
	//일주일 동안 팔린 제품 리스트
	public List<Sale> selectByWeek() {
		List<Sale> results = null;
		String sql = "SELECT * FROM sale WHERE soldDate >= DATE_SUB(CURDATE(), INTERVAL 1 WEEK) AND soldDate < CURDATE()";
		results= this.jdbcTemplate.query(sql,
				new RowMapper<Sale>() {
			public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
                Sale sale = new Sale(
                		rs.getInt("count"),
                		rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("soldDate"),
                        rs.getString("type"));
                return sale;
            }
		});
		return results;
	}
	//한달 매출액
	public int MonthSum() {
		String sql = "select sum(price * count) as 'sum' from sale where month(soldDate) = month(now())";
		return this.jdbcTemplate.queryForObject(sql,Integer.class);
    }
	//한달 동안 팔린 제품 리스트
	public List<Sale> selectByMonth() {
		List<Sale> results = null;
		String sql = "SELECT * FROM sale WHERE soldDate >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH) AND soldDate < CURDATE()";
		results= this.jdbcTemplate.query(sql,
				new RowMapper<Sale>() {
			public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
                Sale sale = new Sale(
                		rs.getInt("count"),
                		rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("soldDate"),
                        rs.getString("type"));
                return sale;
            }
		});
		return results;
	}	
	//가장 많이 팔린 상품부터 내림차순으로 제품 리스트
	public List<Sale> selectByBest() {
		List<Sale> results = null;
		String sql = "SELECT * FROM sale ORDER BY count DESC";
		results= this.jdbcTemplate.query(sql,
				new RowMapper<Sale>() {
			public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
                Sale sale = new Sale(
                		rs.getInt("count"),
                		rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("soldDate"),
                        rs.getString("type"));
                return sale;
            }
		});
		return results;
	}	
}
