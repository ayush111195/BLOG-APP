package com.ayush.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.blog.payloads.UserDto;
import com.ayush.blog.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	//post-create user--->>
	@PostMapping("/")
	public ResponseEntity<UserDto>createdUser(@RequestBody UserDto userDto){
		UserDto createUser = this.userService.createUser(userDto);
		return new ResponseEntity(createUser,HttpStatus.CREATED);
		
	}
	
	
}
