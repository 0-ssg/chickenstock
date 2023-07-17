package ssg.com.a.service;

import java.util.List;

import ssg.com.a.dto.BbsComment;
import ssg.com.a.dto.BbsDto;
import ssg.com.a.dto.BbsParam;

public interface BbsService {
	
	List<BbsDto> bbslist(BbsParam param);
	int getAllBbs(BbsParam param);
	
	boolean bbswrite(BbsDto dto);
	BbsDto bbsdetail(int seq);
	
	BbsDto bbsget(int seq);
	
	boolean bbsupdate(BbsDto dto);
	
	boolean bbsanswer(BbsDto dto);
	
	boolean bbsanswerAf(BbsDto dto);
	
	boolean commentWrite(BbsComment comment);
	List<BbsComment> commentList(int seq);
}
