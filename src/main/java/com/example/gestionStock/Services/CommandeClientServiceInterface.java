package com.example.gestionStock.Services;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.example.gestionStock.Dto.ArticleDto;
import com.example.gestionStock.Dto.CommandeClientDto;



public interface CommandeClientServiceInterface {

	
	
	CommandeClientDto save(CommandeClientDto commandeClientDto);
	
	CommandeClientDto findById(Integer id);
	
	CommandeClientDto findByCode(String code);
	
	List<CommandeClientDto> findAll();
	
	void delete(Integer id);
	
	
	
}
