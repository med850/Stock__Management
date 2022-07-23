package com.example.gestionStock.Services;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.example.gestionStock.Dto.CommandeFournisseurDto;




public interface CommandeFournisseurServiceInterface {

	
	
	CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);
	
	CommandeFournisseurDto findById(Integer id);
	
	CommandeFournisseurDto findByCode(String codes);
	
	List<CommandeFournisseurDto> findAll();
	
	void delete(Integer id);
	
	
	
}
