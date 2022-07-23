package com.example.gestionStock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.gestionStock.Controller.Api.UserApi;
import com.example.gestionStock.Dto.UserDto;
import com.example.gestionStock.Services.UserServiceInterface;

public class UserController implements UserApi{

	
	private UserServiceInterface userService;
	
	
	
	
	@Autowired
	public UserController(UserServiceInterface userService) {
		this.userService = userService;
	}

	@Override
	public UserDto save(UserDto userDto) {
		
		return userService.save(userDto);
	}

	@Override
	public UserDto findById(Integer id) {
		
		return userService.findById(id);
	}

	@Override
	public List<UserDto> findAll() {
		
		return userService.findAll();
	}

	@Override
	public void delete(Integer id) {
		userService.delete(id);
		
	}

}
