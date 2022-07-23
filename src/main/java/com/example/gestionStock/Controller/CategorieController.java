package com.example.gestionStock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionStock.Controller.Api.CategorieApi;
import com.example.gestionStock.Dto.CategorieDto;
import com.example.gestionStock.Services.CategorieServiceInterface;


@RestController
public class CategorieController implements CategorieApi{

	

	private CategorieServiceInterface categorieService;
	
	
	
	@Autowired
	public CategorieController(CategorieServiceInterface categorieService) {
		this.categorieService = categorieService;
	}

	@Override
	public CategorieDto save(CategorieDto categorieDto) {
		
		return categorieService.save(categorieDto);
	}

	@Override
	public CategorieDto findById(Integer idCategorie) {
		
		return categorieService.findById(idCategorie);
	}

	@Override
	public CategorieDto findByCode(String codeCategorie) {
		
		return categorieService.findByCode(codeCategorie);
	}

	@Override
	public List<CategorieDto> findAll() {
		return categorieService.findAll();
	}

	@Override
	public void delete(Integer id) {
		categorieService.delete(id);
		
	}

	
	
	
	
}
