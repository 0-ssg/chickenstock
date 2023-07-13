package ssg.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssg.com.a.dao.MemberDao;
import ssg.com.a.dto.MemberDto;
import ssg.com.a.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao dao;		// MemberDao dao = new MemberDaoImpl();

	@Override
	public List<MemberDto> allMember() {		
		return dao.allMember();
	}

	@Override
	public MemberDto find(String id) {
		return dao.find(id);
	}	
	
	
}






