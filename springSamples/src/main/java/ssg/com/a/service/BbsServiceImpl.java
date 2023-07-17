package ssg.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssg.com.a.dao.BbsDao;
import ssg.com.a.dao.MemberDao;
import ssg.com.a.dto.BbsComment;
import ssg.com.a.dto.BbsDto;
import ssg.com.a.dto.BbsParam;

@Service
public class BbsServiceImpl implements BbsService{

	@Autowired
	BbsDao dao;

	@Override
	public List<BbsDto> bbslist(BbsParam param) {
		// TODO Auto-generated method stub
		return dao.bbslist(param);
	}

	@Override
	public int getAllBbs(BbsParam param) {
		// TODO Auto-generated method stub
		return dao.getAllBbs(param);
	}

	@Override
	public boolean bbswrite(BbsDto dto) {
		return dao.bbswrite(dto)>0?true:false;
	}

	@Override
	public BbsDto bbsdetail(int seq) {
		return dao.bbsdetail(seq);
	}

	@Override
	public BbsDto bbsget(int seq) {
		return dao.bbsget(seq);
	}

	@Override
	public boolean bbsupdate(BbsDto dto) {
		return dao.bbsupdate(dto)>0?true:false;
	}

	@Override
	public boolean bbsanswer(BbsDto dto) {
		try {
	        // Increase the step of existing replies by 1
	        dao.bbsanswer(dto);
	        // Insert the new reply with increased step and depth
	        dao.bbsanswerAf(dto);
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
		/* return dao.bbsanswer(dto)>0; */
	}
	
	@Override
	public boolean bbsanswerAf(BbsDto dto) {
		return dao.bbsanswerAf(dto)>0;
	}

	@Override
	public boolean commentWrite(BbsComment comment) {
		return dao.commentWrite(comment)>0;
	}

	@Override
	public List<BbsComment> commentList(int seq) {
		return dao.commentList(seq);
	}
	
	
	
}
