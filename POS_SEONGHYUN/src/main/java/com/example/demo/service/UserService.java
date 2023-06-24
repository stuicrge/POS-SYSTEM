package com.example.demo.service;

import java.time.LocalDateTime;
import com.example.demo.dao.UserDao;
import com.example.demo.dto.User;

public class UserService {
	private UserDao userDao;
	
	// User서비스에 유저 데이터들을 첨부
	public UserService(UserDao userDao) {
		this.userDao= userDao;
		}
	
	// 유저 회원가입 서비스
	public Long regist(User use) {
	
		User newUser= new User(use.getUserId(), use.getUserEmail(), use.getUserPw(), use.getUserName(),use.getUserType());
		userDao.insert(newUser);
		return newUser.getId();
		
	}
	
	// 유저 로그인 서비스
	public User login(String userId, String userPw) {
		return userDao.login(userId, userPw);
	}
	
	//유저 비밀번호 변경 서비스
	public void changePw(User user) {
		userDao.updatePassword(user);
	}
	
}
