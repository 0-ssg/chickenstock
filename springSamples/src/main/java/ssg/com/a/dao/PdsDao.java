package ssg.com.a.dao;

import java.util.List;

import ssg.com.a.dto.PdsDto;

public interface PdsDao {

	List<PdsDto> pdslist();
	
	int uploadPds(PdsDto pds);
	
	PdsDto getPds(int seq); // 다운로드
}
