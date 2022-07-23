package com.example.gestionStock.Services;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.example.gestionStock.Dto.UserDto;



public interface UserServiceInterface {

	
	
	

	UserDto save(UserDto userDto);
	
	
	UserDto findById(Integer id);
	
	
	List<UserDto>findAll();
	
	
	void delete(Integer id);
}
