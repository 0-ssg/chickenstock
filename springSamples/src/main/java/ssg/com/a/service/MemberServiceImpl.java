package ssg.com.a.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssg.com.a.dao.MemberDao;
import ssg.com.a.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao dao;

	@Override
	public boolean idcheck(String id) {
		return dao.idcheck(id)>0?true:false; // 하나 이상이니 들어갔다는 의미
	}

	@Override
	public boolean addMember(MemberDto dto) {
		return dao.addMember(dto)>0?true:false;
	}

	@Override
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}
	
	
	
}
