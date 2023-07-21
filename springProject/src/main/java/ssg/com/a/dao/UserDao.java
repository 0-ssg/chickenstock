package ssg.com.a.dao;


import ssg.com.a.dto.UserDto;

public interface UserDao {

	int idcheck(String id);	
	int addmember(UserDto dto);
	
	UserDto login(UserDto dto);
}
