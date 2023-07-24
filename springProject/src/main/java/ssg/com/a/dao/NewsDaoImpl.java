package ssg.com.a.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssg.com.a.dto.BbsComment;
import ssg.com.a.dto.BbsDto;
import ssg.com.a.dto.BbsParam;
import ssg.com.a.dto.NewsComment;
import ssg.com.a.dto.NewsDto;
import ssg.com.a.dto.NewsParam;

@Repository
public class NewsDaoImpl implements NewsDao{

	@Autowired
	SqlSessionTemplate session;
	
	String ns = "News.";

	@Override
	public List<NewsDto> bbslist(NewsParam param) {
		return session.selectList(ns + "bbslist", param);		
	}

	@Override
	public int getAllBbs(NewsParam param) {
		return session.selectOne(ns + "getallbbs", param);
	}

	@Override
	public int bbswrite(NewsDto dto) {		
		return session.insert(ns + "bbswrite", dto);
	}

	@Override
	public NewsDto bbsdetail(int seq) {		
		return session.selectOne(ns + "bbsdetail", seq);
	}

	@Override
	public NewsDto bbsget(int seq) {
		return session.selectOne(ns + "bbsget", seq);
	}

	@Override
	public int bbsupdate(NewsDto dto) {
		return session.update(ns + "bbsupdate", dto);
	}
	
	@Override
	public int bbsdelete(NewsDto dto) {
		return session.update(ns + "bbsdelete", dto);
	}

	@Override
	public int commentWrite(NewsComment comment) {		
		return session.insert(ns + "commentWrite", comment);
	}

	@Override
	public List<NewsComment> commentList(int seq) {		
		return session.selectList(ns + "commentList", seq);
	}

	
	
	
}
