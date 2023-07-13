package ssg.com.a.controller;

import java.net.http.HttpHeaders;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;

import netscape.javascript.JSObject;
import ssg.com.a.dto.MemberDto;
import ssg.com.a.service.MemberService;

@Controller
public class HelloController {
	
	@Autowired
	MemberService service;	// MemberService service = new MemberServiceImpl();

	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	public String hello(Model model) {
		System.out.println("HelloController hello() " + new Date());
		
		// 짐 싸기
		List<MemberDto> list = service.allMember();
		model.addAttribute("list", list);
		
		// 짐 보내기
		return "hello";
	}
	
	@GetMapping("find.do")
	public String findMember(String id, Model model) {
		System.out.println("HelloController findMember() " + new Date());
		
		// 짐 싸기
		MemberDto mem = service.find(id);
		model.addAttribute("mem", mem);
		
		// 짐 보내기 (jsp 파일명)
		return "hello";
	}
	
	@ResponseBody	// <- ajax인 경우에만 추가	
	// return이 String인 경우
	// 1. RequestMapping 사용 필수
	// 2. produces = ~ 추가
	@RequestMapping(value="idcheck.do",
							method=RequestMethod.GET, 
							produces="application/String;charset=utf-8")// <- 문자열이 한글인 경우만
	public String idcheck(String id) {
		System.out.println("HelloController idcheck() " + new Date());
		System.out.println("id" + id);
		
		return "오케이";
	}
	
	@ResponseBody
	@RequestMapping(value = "account.do",method=RequestMethod.POST)
	public String account(MemberDto mem) {
		System.out.println("HelloController account() " + new Date());
		System.out.println(mem.toString());
		
	    return "OK";
	    
	}
	
	@ResponseBody
	@RequestMapping(value = "getlist.do",method=RequestMethod.GET)
	public List<MemberDto> getlist() {
		System.out.println("HelloController getlist()" + new Date());
		
		List<MemberDto> list = service.allMember();
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "getmap.do",method=RequestMethod.GET)
	public Map<String, Object> getmap(){
		System.out.println("HelloController getmap()" + new Date());
		
		String message = "이것은 성공의 열쇠다";
		List<MemberDto> list = service.allMember();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("list", list);
		
		return map;
	}
}

	
















