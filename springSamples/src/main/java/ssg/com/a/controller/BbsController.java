package ssg.com.a.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ssg.com.a.dao.BbsDao;
import ssg.com.a.dto.BbsDto;
import ssg.com.a.dto.BbsParam;
import ssg.com.a.dto.MemberDto;
import ssg.com.a.service.BbsService;

@Controller
public class BbsController {

	@Autowired
	BbsService service;

	@GetMapping("bbslist.do")
	public String bbslist(BbsParam param, Model model) {
		System.out.println("BbsController bbslist() " + new Date());

		if (param == null || param.getSearch() == null || param.getChoice() == null) {
			param = new BbsParam("", "", 0);
		}
		
		List<BbsDto> list = service.bbslist(param);
		
		// 글의 총 수
		int count = service.getAllBbs(param); // 23
		// 페이지 계산
		int pageBbs = count / 10; // -> 2
		if ((count % 10) > 0) {
			pageBbs = pageBbs + 1; // -> 3
		}

		model.addAttribute("bbslist", list);
		model.addAttribute("pageBbs", pageBbs);
		model.addAttribute("param", param);

		return "bbslist";
	}

	@GetMapping("bbswrite.do")
	public String bbswrite() {
		return "bbswrite";
	}

	@PostMapping("bbswriteAf.do")
	public String bbswrite(BbsDto dto, Model model) {
		System.out.println("BbsController bbswriteAf() " + new Date());

		boolean isS = service.bbswrite(dto);

		String message = "BBSWRITE_YES";
		if (isS == false) {
			message = "BBSWRITE_NO";
		}
		model.addAttribute("bbswrite", message);

		return "message"; // .jsp로 보냄
	}
	
	@GetMapping("bbsdetail.do")
	public String bbsdetail(int seq, Model model) {
		System.out.println("BbsController bbsdetail() " + new Date());
		
		BbsDto dto = service.bbsdetail(seq);
		model.addAttribute("bbsdto",dto);
		
		return "bbsdetail";
	}
	
	@GetMapping("bbsupdate.do")
	public String bbsupdate(int seq, Model model) {
		System.out.println("BbsController bbsupdate() " + new Date());
		
		BbsDto dto = service.bbsget(seq);
		
		model.addAttribute("bbsDto", dto);
		
		return "bbsupdate";
	}
	
	@PostMapping("bbsupdateAf.do")
	public String bbsupdateAf(BbsDto dto, Model model) {
		System.out.println("BbsController bbsupdateAf() " + new Date());
		
		boolean isS = service.bbsupdate(dto);
		
		String message = "BBSUPDATE_YES";
		if (isS == false) {
			message = "BBSUPDATE_NO";
		}
		model.addAttribute("bbsupdate", message);
		
		return "message";
	}
}



















