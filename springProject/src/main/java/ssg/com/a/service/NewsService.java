package ssg.com.a.service;

import java.util.List;

import ssg.com.a.dto.BbsComment;
import ssg.com.a.dto.BbsDto;
import ssg.com.a.dto.BbsParam;
import ssg.com.a.dto.NewsComment;
import ssg.com.a.dto.NewsDto;
import ssg.com.a.dto.NewsParam;

public interface NewsService {

	List<NewsDto> bbslist(NewsParam param);
	int getAllBbs(NewsParam param);	
	boolean bbswrite(NewsDto dto);	
	NewsDto bbsdetail(int seq);
	
	NewsDto bbsget(int seq);
	
	boolean bbsupdate(NewsDto dto);
	
	boolean bbsdelete(NewsDto dto);
	
	boolean commentWrite(NewsComment comment);
	List<NewsComment> commentList(int seq);
}








