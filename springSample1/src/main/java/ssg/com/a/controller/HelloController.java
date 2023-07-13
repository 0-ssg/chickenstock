package ssg.com.a.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		// <- annotation
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("HelloController hello() " + new Date());
		
		return "hello";		// hello.jsp 로 가라!
	}
}
