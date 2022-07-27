package com.example.gestionStock.Services.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.gestionStock.Dto.UsersDto;
import com.example.gestionStock.Entity.Users;
import com.example.gestionStock.Entity.auth.ExtendedUser;
import com.example.gestionStock.Exception.EntityNotFoundException;
import com.example.gestionStock.Exception.ErrorCodes;
import com.example.gestionStock.Repository.UsersRepository;
import com.example.gestionStock.Services.UserServiceInterface;
import com.example.gestionStock.Services.Implements.UserServiceImp;

@Service
public class ApplicationUserDetailsService implements UserDetailsService{

	
	private UserServiceImp userService;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		
		UsersDto user = userService.findByEmail(email);
				
		List<SimpleGrantedAuthority>authorities = new ArrayList<>();
		
		user.getRoles().forEach(role->authorities.add(new SimpleGrantedAuthority(role.getRoleName()) ));
		
		return new ExtendedUser(user.getEmail(), user.getMotDePasse(), user.getEntreprise().getId(), authorities);
	}

	
	
	
}
