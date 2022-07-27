package com.example.gestionStock.Services.Implements;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.gestionStock.Dto.ClientDto;
import com.example.gestionStock.Dto.UsersDto;
import com.example.gestionStock.Entity.Client;
import com.example.gestionStock.Entity.Users;
import com.example.gestionStock.Exception.EntityNotFoundException;
import com.example.gestionStock.Exception.ErrorCodes;
import com.example.gestionStock.Exception.InvalidEntityException;
import com.example.gestionStock.Repository.UsersRepository;
import com.example.gestionStock.Services.UserServiceInterface;
import com.example.gestionStock.Validators.ClientValidator;
import com.example.gestionStock.Validators.UserValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImp implements UserServiceInterface{

	
	
	
	UsersRepository userRepository;
	

	
	@Autowired
	public UserServiceImp(UsersRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UsersDto save(UsersDto userDto) {
	
		List<String>errors = UserValidator.validate(userDto);
		
		if(!errors.isEmpty()) {
			
			log.error("User n'est pas valide", userDto);
			
			throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.USER_NOT_VALID, errors);

		}	
		
		return UsersDto.fromEntity(userRepository.save(UsersDto.toEntity(userDto)));
	}

	@Override
	public UsersDto findById(Integer id) {
		
		if(id == null) {
			
			log.error("L'id d'utilisateur est null");
			return null;
		}
		
		Optional<Users>user = userRepository.findById(id);
		return Optional.of(UsersDto.fromEntity(user.get())).orElseThrow(
				()-> new EntityNotFoundException("L'id" + id + "n'existe pas", ErrorCodes.USER_NOT_FOUND));
	}

	@Override
	public List<UsersDto> findAll() {
		
		return userRepository.findAll().stream()
				.map(UsersDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		
if(id == null) {
			
			log.error("L'id d'utilisateur est null");
			return;
		}
		
		userRepository.deleteById(id);
		
	}

	@Override
	public UsersDto findByEmail(String email) {
		
		return userRepository.findUserByEmail(email)
				.map(UsersDto::fromEntity)
				.orElseThrow(
						()-> new EntityNotFoundException(
								"Aucun utilisateur avec l'email = " + email + "n'été pas trouvé dans la base de données", ErrorCodes.USER_NOT_FOUND));
	
	}

}
