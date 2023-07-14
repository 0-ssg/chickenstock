package ssg.com.a.controller;

import java.net.http.HttpHeaders;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;

import netscape.javascript.JSObject;
import ssg.com.a.dto.MemberDto;
import ssg.com.a.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;	// MemberService service = new MemberServiceImpl();

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		System.out.println("MemberController login() " + new Date());
		return "login"; // .jsp
	}
	
	@GetMapping("regi.do")
	public String regi() {
		System.out.println("MemberController regi() " + new Date());
		
		return "regi"; // .jsp
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
	
	@PostMapping("regiAf.do") // regi.jsp의 <form action="regiAf.do" method="post">와 매칭
	public String addMember(MemberDto mem, Model model) {// regi.jsp로부터 id, pwd, name, email이 들어옴
		System.out.println("MemberController addMember() " + new Date());
		
		boolean isS = service.addMember(mem);
		String message = "MEMBER_YES";
		if(isS == false) {
			message = "MEMBER_NO";
		}
		model.addAttribute("message", message);
		
		return "message"; // .jsp로 보냄
	}
	
	@PostMapping("loginAf.do")							// session에 저장하기 위한 파라미터
	public String login(MemberDto mem, Model model, HttpServletRequest request) {
		System.out.println("MemberController login() " + new Date());
		
		MemberDto dto = service.login(mem);
		String loginmsg = "LOGIN_NO";
		if(dto != null) {
			request.getSession().setAttribute("login", dto);	// session에 저장
			loginmsg = "LOGIN_YES";
		}
		model.addAttribute("loginmsg", loginmsg);
		
		return "message"; // .jsp로 보냄
	}
}

	
















