package com.example.gestionStock.Services;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.example.gestionStock.Dto.CategorieDto;
import com.example.gestionStock.Dto.CommandeFournisseurDto;


public interface CategorieServiceInterface {

	
	
	CategorieDto save(CategorieDto categorieDto);
	
	
	CategorieDto findById(Integer id);
	
	
	CategorieDto findByCode(String code);
	
	
	List<CategorieDto>findAll();
	
	
	void delete(Integer id);
	
	
}
