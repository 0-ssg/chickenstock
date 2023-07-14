package ssg.com.a.service;

import ssg.com.a.dto.MemberDto;

public interface MemberService {
	public boolean idcheck(String id);
	
	public boolean addMember(MemberDto dto);
	
	public MemberDto login(MemberDto dto);
	
}
