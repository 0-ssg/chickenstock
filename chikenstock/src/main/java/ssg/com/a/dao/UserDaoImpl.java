package ssg.com.a.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssg.com.a.dto.MemberDto;
import ssg.com.a.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SqlSession session;
//	SqlSessionTemplate session;
	
	String ns = "User.";

	@Override
	public int idcheck(String id) {		
		int count = session.selectOne(ns + "idcheck", id);		
		return count;
	}

	@Override
	public int addmember(UserDto dto) {
		return session.insert(ns + "addmember", dto);		
	}

	@Override
	public UserDto login(UserDto dto) {		
		return session.selectOne(ns + "login", dto);
	}
	
	
}





