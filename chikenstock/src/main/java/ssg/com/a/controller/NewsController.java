package ssg.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ssg.com.a.dto.NewsDto;
import ssg.com.a.dto.NewsParam;
import ssg.com.a.service.NewsService;

@Controller
public class NewsController {

	@Autowired
	NewsService service;
	
	@GetMapping("bbslist.do")
	public String bbslist(NewsParam param, Model model) {
		System.out.println("NewsController bbslist() " + new Date());
		System.out.println(param.toString());
		
		if(param == null || param.getSearch() == null || param.getChoice() == null) {
			param = new NewsParam("", "", 0);
		}
		
		List<NewsDto> list = service.bbslist(param);
				
		// 글의 총수
		int count = service.getAllBbs(param);	
		// 페이지를 계산
		int pageBbs = count / 10;	
		if((count % 10) > 0) {
			pageBbs = pageBbs + 1;	
		}		
		
		model.addAttribute("bbslist", list);
		model.addAttribute("pageBbs", pageBbs);
		model.addAttribute("param", param);
		
		model.addAttribute("content", "bbs/bbslist");
		
		return "main";
	}	
	
	@GetMapping("bbswrite.do")
	public String bbswrite(Model model) {
		System.out.println("NewsController bbswrite() " + new Date());
		
		model.addAttribute("content", "bbs/bbswrite");
		return "main";
	}
	
	@PostMapping("bbswriteAf.do")
	public String bbswriteAf(NewsDto dto, Model model) {
		System.out.println("NewsController bbswriteAf() " + new Date());
		
		boolean isS = service.bbswrite(dto);
		String newswrite = "BBS_ADD_OK";
		if(isS == false) {
			newswrite = "BBS_ADD_NO";
		}
		model.addAttribute("newswrite", newswrite);
		
		return "message";
	}
	
	@GetMapping("bbsdetail.do")
	public String bbsdetail(int seq, Model model) {
		System.out.println("NewsController bbsdetail() " + new Date());
		
		NewsDto dto = service.bbsdetail(seq);		
		model.addAttribute("newsdto", dto);
		
		model.addAttribute("content", "bbs/bbsdetail");
		return "main";
	}
	
	@GetMapping("bbsupdate.do")
	public String bbsupdate(int seq, Model model) {
		System.out.println("NewsController bbsupdate() " + new Date());
		
		NewsDto dto = service.bbsget(seq);

		model.addAttribute("newsDto", dto);

		
		model.addAttribute("content", "bbs/bbsupdate");
		return "main";
	}
	
	@PostMapping("bbsupdateAf.do")
	public String bbsupdateAf(NewsDto dto, Model model) {
		System.out.println("NewsController bbsupdateAf() " + new Date());
		
		boolean isS = service.bbsupdate(dto);
		
		String message = "BBSUPDATE_YES";
		if (isS == false) {
			message = "BBSUPDATE_NO";
		}
		model.addAttribute("newsupdate", message);
		
		return "message";
	}
	
	@GetMapping("bbsdelete.do")
	public String bbsdelete(int seq, Model model) {
		System.out.println("NewsController bbsdeleteAf() " + new Date());
		
		NewsDto dto = service.bbsget(seq);
		
		boolean isS = service.bbsdelete(dto);
		
		String message = "BBSDELETE_YES";
		if(isS == false) {
			message = "BBSDELETE_YES";
		}
		model.addAttribute("newsdelete", message);
		
		return "message";
		
	}
}



















