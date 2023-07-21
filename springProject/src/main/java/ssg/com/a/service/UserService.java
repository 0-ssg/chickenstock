package ssg.com.a.service;

import ssg.com.a.dto.UserDto;

public interface UserService {

	boolean idcheck(String id); // prototype	
	boolean addmember(UserDto dto);
	
	UserDto login(UserDto dto);
}
