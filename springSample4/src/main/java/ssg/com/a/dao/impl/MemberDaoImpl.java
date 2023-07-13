package ssg.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssg.com.a.dao.MemberDao;
import ssg.com.a.dto.MemberDto;

@Repository // =저장소
public class MemberDaoImpl implements MemberDao{

	// MyBatis 접근
	@Autowired	// <- 자동생성
	SqlSession session;

	@Override
	public List<MemberDto> allMember() {
		List<MemberDto> list = session.selectList("Member.allMember");
		return list;
	}
	
	@Override
	public MemberDto find(String id) {
		return session.selectOne("Member.find",id);
	}
	
	
}







