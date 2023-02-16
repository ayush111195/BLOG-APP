package com.ayush.blog.services;

import java.util.List;

import com.ayush.blog.payloads.UserDto;

public interface UserService {

	//for create the user--->>
	UserDto createUser(UserDto userDto);
	
	//for update the user-->>
	UserDto updateUser(UserDto userDto, int userId);
	
	//for get user by id---->>
	UserDto getUsserById(int userId);
	
	//for get all user--->>
	List<UserDto>getAllUser();
	
	//for dlt the user--->>
	void deleteUser(int userId);
}
