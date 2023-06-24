package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.dto.*;
import com.example.demo.service.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	//main페이지
	@GetMapping( "/main" )
	public String main1() {   return "main";   }
	
	//homepage페이지
	@GetMapping( "/homepage" )
	public String homepage() {   return "homepage";   }
	
	//회원가입할때
	@PostMapping("/regist")
   public String regist(User use) {   
      try {
         userservice.regist(use);
         } catch (Exception ex) {
            ex.printStackTrace();
            }
      return "redirect:/main";
      }
		
	// 회원가입페이지로 들어갈때
	@RequestMapping("/userjoin")
	public String join1(Model model) {
		
		return "userjoin";
	}
	
	// 로그인할때
	@RequestMapping(value="/homepage" , method = RequestMethod.POST)  // 로그인 페이지
	public String login(Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes ra) {
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		User check = userservice.login(userId, userPw);
		
		if(check == null) {   // 아이디 비밀번호 일치하지 않을 때
			int result = 0;
			ra.addFlashAttribute("result", result);
			return "redirect: /";
		}
		
		session.setAttribute("user", check);  // 일치하면
		System.out.println("로그인 성공 " + check);		
		return "/homepage";
	}
	//로그아웃
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/main";
	}
	
	//비밀번호 변경하는 페이지로 들어갈때
	@GetMapping(value="/changePassword")
	public String changePassword1() {
		return "changePassword";
	}
	
	//비밀 번호 변경 버튼 누를때
	@PostMapping(value="/user/changePassword")
	public String changePassword2(User user) {
		userservice.changePw(user);
		return "redirect:/homepage";
	}
		
}