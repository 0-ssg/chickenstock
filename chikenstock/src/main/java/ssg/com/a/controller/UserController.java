package ssg.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.Session;

import ssg.com.a.dto.UserDto;
import ssg.com.a.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;
	
	@RequestMapping(value = "login.do")
	public String login(Model model) {
		System.out.println("UserController login() " + new Date());
		/* model.addAttribute("content", "member/login"); */
		model.addAttribute("content", "member/login");
		return "main";
	}
	
	@RequestMapping(value = "logout.do")
	public String logout(HttpServletRequest request) {
		System.out.println("UserController logout() " + new Date());		
		request.getSession().removeAttribute("login");		
		return "redirect:/login.do";
	}
	
	@PostMapping("loginAf.do")
	public String login(String user_id, String password, Model model, HttpServletRequest request) {
		System.out.println("UserController loginAf() " + new Date());
		//System.out.println(user);
		UserDto user = new UserDto();
		user.setUser_id(user_id);
		user.setPassword(password);
		UserDto dto = service.login(user);
		/* System.out.println(dto.toString()); */
		String loginmsg = "LOGIN_NO";
		if(dto != null) {
			request.getSession().setAttribute("login", dto);	// session에 저장			
			loginmsg = "LOGIN_YES";
		}
		model.addAttribute("loginmsg", loginmsg);
		
		return "message";
	}
	
	@GetMapping("regi.do")
	public String regi() {
		System.out.println("MemberController regi() " + new Date());
		return "regi";
	}
	
	@ResponseBody
	@PostMapping("idcheck.do")
	public String idcheck(String id) {
		System.out.println("MemberController idcheck() " + new Date());
		
		boolean isS = service.idcheck(id);
		String msg = "YES";
		if(isS == true) {
			msg = "NO";
		}
		
		return msg;
	}
	
	@PostMapping("regiAf.do")
	public String regiAf(UserDto user, Model model) {
		System.out.println("MemberController regiAf() " + new Date());
		
		boolean isS = service.addmember(user);
		String message = "MEMBER_YES";
		if(isS == false) {
			message = "MEMBER_NO";
		}
		model.addAttribute("message", message);
		
		return "message";
	}	
	
	
}













