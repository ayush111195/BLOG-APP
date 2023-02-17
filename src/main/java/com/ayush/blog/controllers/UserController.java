package com.ayush.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.blog.payloads.ApiResponce;
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
	return new ResponseEntity<UserDto>(createUser,HttpStatus.CREATED);
		
	}
	//put -update user--->>
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable Integer userId){
		UserDto updateUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updateUser) ;
		
	}
	
	//delete-delete user--->>
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponce> deleteUser(@PathVariable int userId){
		this.userService.deleteUser(userId);
		return new  ResponseEntity<ApiResponce>( new ApiResponce("user delete successfuly",true),HttpStatus.OK);
		
	}
	 
	//get-user get----->>
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto> allUser = this.userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	//get-single user get--->>
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable int useId){
		UserDto usserById = this.userService.getUsserById(useId);
		return ResponseEntity.ok(usserById);
	}
}
