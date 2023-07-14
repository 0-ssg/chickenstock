package ssg.com.a.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssg.com.a.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	// Batis 접근
	@Autowired	// <- 자동생성
	SqlSession session;				// ibatis
	//SqlSessionTemplate session;	// mybatis
	
	String ns = "Member.";
	
	// session.seletOne(String, Object): 
	// 1. String에 해당되는 쿼리문에 Object 입력 ( 객체를 넣을 경우 해당 객체안 변수와 매칭되는 변수만 입력됨 ) 
	// 2. String에 해당되는 쿼리문의 결과값을 출력 
	
	@Override
	public int idcheck(String id) {
								 // ns = "Member."
		int count = session.selectOne(ns + "idcheck", id);
		
		return count;
	}

	@Override
	public int addMember(MemberDto dto) {
		
		return session.insert(ns + "addMember", dto); // insert는 자동 count
	}

	@Override
	public MemberDto login(MemberDto dto) {
	
		return session.selectOne(ns + "login", dto);
	}
	
	
	
	
}
