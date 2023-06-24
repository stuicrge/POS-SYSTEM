package com.example.demo.dto;

public class User {

	private Long id; // 구별해주는 id값
	private String userId; // 회원의 아이디
	private String userPw; // 회원의 비밀번호
	private String userName; // 회원의 이름
	private String userEmail; // 회원의 메일
	private String userType; // 관리자일까 직원일까?
	private String confirmPassword; // 비밀번호 확인
	
	// service, dao에서 쓰일 User
	public User(String userId, String userEmail,String userPw, String userName, String userType) {
		this.userId = userId;
		this.userName = userName;
		this.userPw = userPw;
		this.userEmail = userEmail;
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
		
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	// 비밀번호가 확인 비밀번호와 같아야한다는 메소드
	public boolean isPasswordEqualToConfirmPassword() {return userPw.equals(confirmPassword);
	}
	
}
