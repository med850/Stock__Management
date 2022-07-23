package com.example.gestionStock.Controller.Api;

import static com.example.gestionStock.Utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.gestionStock.Dto.UserDto;

import io.swagger.annotations.Api;


@Api(APP_ROOT + "/users")
public interface UserApi {

	
	@PostMapping(value = APP_ROOT + "/users/create")
	UserDto save(@RequestBody UserDto userDto);
	
	@GetMapping(value = APP_ROOT + "/users/{idUser}")
	UserDto findById(@PathVariable("idUser") Integer id);
	
	@GetMapping(value = APP_ROOT + "/users/all")
	List<UserDto>findAll();
	
	@DeleteMapping(value = APP_ROOT + "/users/delete/{idUser}")
	void delete(@PathVariable("idUser")Integer id);
	
}
