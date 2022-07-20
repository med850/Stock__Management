package com.example.gestionStock.Services;

import java.util.List;

import com.example.gestionStock.Dto.CategorieDto;

public interface CategorieServiceInterface {

	
	
	CategorieDto save(CategorieDto cleintDto);
	
	
	CategorieDto findById(Integer id);
	
	
	CategorieDto findByCode(String code);
	
	
	List<CategorieDto>findAll();
	
	
	void delete(Integer id);
	
	
}
