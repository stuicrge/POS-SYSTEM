package com.example.demo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.example.demo.dto.User;


public class UserDao {

	
	private JdbcTemplate jdbcTemplate;	
	public UserDao(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);	
	}
	
	// id 중복체크 메소드
	public int selectById(String userId) {
      int idCheck = jdbcTemplate.queryForObject("select count(*) from USER where userId = ?",Integer.class, userId);
      return idCheck;
    }
	// 로그인해주는 메소드  
	public User login(String userId, String userPw) {
		String sql = "select * from USER where userId = ? and userPw = ?";
		List<User> results= this.jdbcTemplate.query(sql,
									new RowMapper<User>() {
										public User mapRow(ResultSet rs, int rowNum) throws SQLException {
											User user = new User(
												rs.getString("userEmail"),
												rs.getString("userPw"),
												rs.getString("userId"),
												rs.getString("userName"), 								
												rs.getString("userType"));
											return user; 
										}
									}, userId, userPw);
		return results.isEmpty() ? null : results.get(0);
	}
	// 회원가입 메소드
	public void insert(User user) {	
	    KeyHolder keyHolder = new GeneratedKeyHolder();
	    jdbcTemplate.update(
	    		new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement pstmt = con.prepareStatement(
	    						"insert into USER (userId, userEmail, userPw, userName, userType) values(?, ?, ?, ?, ?)", new String[] {"ID"});
	    						pstmt.setString(1, user.getUserId());
	    						pstmt.setString(2, user.getUserEmail());
	    						pstmt.setString(3, user.getUserPw());
	    						pstmt.setString(4, user.getUserName());
	    						pstmt.setString(5, user.getUserType());
	    						return pstmt;
					}    			
	    		},   		
	    		keyHolder);
	    Number keyValue = keyHolder.getKey();
	   user.setId(keyValue.longValue());
	}
	
	//패스워드 업데이트
	public void updatePassword(User user) {
		jdbcTemplate.update("update User set userPw = ? where userId = ?",
				user.getUserPw(), user.getUserId());
	}
	
}
