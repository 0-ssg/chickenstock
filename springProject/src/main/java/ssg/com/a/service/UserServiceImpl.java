package ssg.com.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssg.com.a.dao.UserDao;
import ssg.com.a.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao dao;

	@Override
	public boolean idcheck(String id) {		
		return dao.idcheck(id)>0?true:false;
	}

	@Override
	public boolean addmember(UserDto dto) {		
		return dao.addmember(dto)>0?true:false;
	}

	@Override
	public UserDto login(UserDto dto) {		
		return dao.login(dto);
	}
	
	
}
