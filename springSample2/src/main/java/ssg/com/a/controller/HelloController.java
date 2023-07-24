package ssg.com.a.controller;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ssg.com.a.dto.StudentDto;

@Controller // <- annotation
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("HelloController hello() " + new Date());

		return "hello"; // hello.jsp 로 가라!
	}

	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("HelloController home() " + new Date());

		String name = "홍길동";

		// 짐 싸기 (HelloController.java -> home.jsp)
		model.addAttribute("name", name);

		// 보내기
		return "home"; // home.jsp로 가라! forward
	}

	// GET이든 POST든 상관안하겠다 선언
	@RequestMapping(value = "world.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String world(String name, int age, Model model) {
		System.out.println("HelloController world()" + new Date());

		System.out.println("name: " + name);
		System.out.println("age: " + age);

		model.addAttribute("name", name);

		return "home";
	}

	// @RequestMapping(value = "object.do", method = RequestMethod.POST)
	// @GetMapping("")
	@PostMapping("object.do")
	public String objectMethod(StudentDto dto) {
		System.out.println("HelloController objectMethod() " + new Date());

		System.out.println(dto.toString());

		return "home";
	}

	/*
	 * message 출력
	 * 
	 * StudentDto -> 3명의 데이터 list로 보낸다
	 */

	@GetMapping("list.do")
	public String listMethod(String message, Model model) {
		System.out.println("HelloController listMethod() " + new Date());
		System.out.println("message:" + message);
		StudentDto li = new StudentDto();

		List<StudentDto> list = new ArrayList<StudentDto>();

		list.add(new StudentDto("홍길동", 24));
		list.add(new StudentDto("성춘향", 16));
		list.add(new StudentDto("일지매", 22));

		li.setList(list);
		System.out.println(li.getList().toString());

		// li속 list의 reference가 복사되기 때문에 listTemp의 변화는 li속 list에도 동일하게 적용됨
		List<StudentDto> listTemp = li.getList();
		System.out.println("before" + list.toString());
		listTemp.add(new StudentDto("존", 32));
		System.out.println("after" + list.toString());

		// 짐 싸기 (HelloController.java -> home.jsp)
		model.addAttribute("list", list);

		return "home";
	}

	/*
	 * @PostMapping("list2.do") public String listMethod2(StudentDto dto) {
	 * System.out.println("HelloController listMethod2() " + new Date());
	 * 
	 * StudentDto li = new StudentDto();
	 * 
	 * li.setList(); List<StudentDto> list = li.getList();
	 * System.out.println(list.toString());
	 * 
	 * list.add(dto); li.setList(list); System.out.println(li.getList().toString());
	 * 
	 * return "home"; }
	 */
}