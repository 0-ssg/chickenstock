package ssg.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssg.com.a.dao.NewsDao;
import ssg.com.a.dto.NewsComment;
import ssg.com.a.dto.NewsDto;
import ssg.com.a.dto.NewsParam;

@Service
public class NewsServiceImpl implements NewsService{

	@Autowired
	NewsDao dao;

	@Override
	public List<NewsDto> bbslist(NewsParam param) {		
		return dao.bbslist(param);
	}

	@Override
	public int getAllBbs(NewsParam param) {		
		return dao.getAllBbs(param);
	}

	@Override
	public boolean bbswrite(NewsDto dto) {		
		return dao.bbswrite(dto)>0?true:false;
	}
	
	@Override
	public NewsDto bbsdetail(int seq) {		
		return dao.bbsdetail(seq);
	}
	
	@Override
	public NewsDto bbsget(int seq) {
		return dao.bbsget(seq);
	}

	@Override
	public boolean bbsupdate(NewsDto dto) {
		return dao.bbsupdate(dto)>0?true:false;
	}
	
	@Override
	public boolean bbsdelete(NewsDto dto) {
		return dao.bbsdelete(dto)>0;
	}

	@Override
	public boolean commentWrite(NewsComment comment) {		
		return dao.commentWrite(comment)>0?true:false;
	}

	@Override
	public List<NewsComment> commentList(int seq) {		
		return dao.commentList(seq);
	}

	
			
	
}
