package com.example.gestionStock.Services;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.example.gestionStock.Dto.UsersDto;



public interface UserServiceInterface {

	
	
	

	UsersDto save(UsersDto userDto);
	
	
	UsersDto findById(Integer id);
	
	
	UsersDto findByEmail(String email);
	
	
	List<UsersDto>findAll();
	
	
	void delete(Integer id);
}
