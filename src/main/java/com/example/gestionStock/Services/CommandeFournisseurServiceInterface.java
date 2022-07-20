package com.example.gestionStock.Services;

import java.util.List;

import com.example.gestionStock.Dto.CommandeFournisseurDto;

public interface CommandeFournisseurServiceInterface {

	
	
	CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);
	
	CommandeFournisseurDto findById(Integer id);
	
	CommandeFournisseurDto findByCode(String code);
	
	List<CommandeFournisseurDto> findAll();
	
	void delete(Integer id);
	
	
	
}
