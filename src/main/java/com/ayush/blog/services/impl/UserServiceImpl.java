package com.ayush.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.blog.entities.User;
import com.ayush.blog.exceptions.ResourceNotFoundException;
import com.ayush.blog.payloads.UserDto;
import com.ayush.blog.repositories.UserRepo;
import com.ayush.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	public ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		User save = this.userRepo.save(user);
		
		return this.userToDto(user);
	}

	@Override
	public UserDto updateUser(UserDto userDto, int userId) {
		User user=this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		User save = this.userRepo.save(user);
		return this.userToDto(save);
	}

	@Override
	public UserDto getUsserById(int userId) {
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		
		List<User> findAll = this.userRepo.findAll();
		
		List<UserDto> collect = findAll.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deleteUser(int userId) {
		
	User user=	this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));

	this.userRepo.delete(user);
	}
	
  public	User dtoToUser(UserDto userDto) {
	User map = this.modelMapper.map(userDto, User.class);
	  
//	User user=new User();
//	user.setId(userDto.getId());
//	user.setName(userDto.getName());
//	user.setEmail(userDto.getEmail());
//	user.setAbout(userDto.getAbout());
//	user.setPassword(userDto.getPassword());
//return user;
	
	return map;
}

public UserDto userToDto(User user)
{
	
	UserDto map1 = this.modelMapper.map(user, UserDto.class);
//	UserDto userdto=new UserDto();
//	userdto.setId(user.getId());
//	userdto.setName(user.getName());
//	userdto.setEmail(user.getEmail());
//	userdto.setAbout(user.getAbout());
//	userdto.setPassword(user.getPassword());
//	return userdto;
	
	return map1;
}

}
