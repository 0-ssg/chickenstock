package ssg.com.a.service;

import java.util.List;

import ssg.com.a.dto.MemberDto;

public interface MemberService {

	List<MemberDto> allMember();
	
	MemberDto find(String id);
}
