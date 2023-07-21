package ssg.com.a.dao;

import java.util.List;

import ssg.com.a.dto.BbsComment;
import ssg.com.a.dto.BbsDto;
import ssg.com.a.dto.BbsParam;
import ssg.com.a.dto.NewsComment;
import ssg.com.a.dto.NewsDto;
import ssg.com.a.dto.NewsParam;

public interface NewsDao {
	
	List<NewsDto> bbslist(NewsParam param);
	int getAllBbs(NewsParam param);	
	int bbswrite(NewsDto dto);	
	NewsDto bbsdetail(int seq);
	
	NewsDto bbsget(int seq);
	
	int bbsupdate(NewsDto dto);
	
	int bbsdelete(NewsDto dto);
	
	int commentWrite(NewsComment comment);
	List<NewsComment> commentList(int seq);
	
}





