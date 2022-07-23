package com.example.gestionStock.Services;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.example.gestionStock.Dto.ClientDto;



public interface ClientServiceInterface {

	
	ClientDto save(ClientDto clientDto);
	
	
	ClientDto findById(Integer id);
	
	
	List<ClientDto>findAll();
	
	
	void delete(Integer id);
	
	
	
}
