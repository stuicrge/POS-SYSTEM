package com.example.demo;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dao.SaleDao;
import com.example.demo.dao.StockDao;
import com.example.demo.dao.UserDao;
import com.example.demo.service.SaleService;
import com.example.demo.service.StockService;
import com.example.demo.service.UserService;
@Configuration
public class BeanConfig {
   
   @Bean(destroyMethod = "close")
   public DataSource dataSource() {
      DataSource ds = new DataSource();
      ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
      ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8&serverTimezone=UTC");
      ds.setUsername("root");
      ds.setPassword("1234");
      return ds;
      }   
   
   @Bean
   public UserDao userDao() {return new UserDao(dataSource());}
   @Bean
   public UserService userservice() {return new UserService(userDao());}
   @Bean
   public StockDao stockDao() {return new StockDao(dataSource());}
   @Bean 
   public StockService stockService() {return new StockService(stockDao());}
   @Bean
   public SaleDao saleDao() {return new SaleDao(dataSource());}
   @Bean
   public SaleService saleService() {return new SaleService(saleDao());}
}