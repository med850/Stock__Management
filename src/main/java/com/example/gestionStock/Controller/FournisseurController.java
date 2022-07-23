package com.example.gestionStock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionStock.Controller.Api.FournisseurApi;
import com.example.gestionStock.Dto.FournisseurDto;
import com.example.gestionStock.Repository.FournisseurRepository;
import com.example.gestionStock.Services.FournisseurServiceInterface;




@RestController
public class FournisseurController implements FournisseurApi{

	
	
	private FournisseurServiceInterface fournisseurService;
	
	
	
	
	@Autowired
	public FournisseurController(FournisseurServiceInterface fournisseurService) {
		this.fournisseurService = fournisseurService;
	}
	
	

	@Override
	public FournisseurDto save(FournisseurDto fournisseurDto) {
		
		return fournisseurService.save(fournisseurDto);
	}

	

	@Override
	public FournisseurDto findById(Integer id) {
		
		return fournisseurService.findById(id);
	}

	@Override
	public List<FournisseurDto> findAll() {
		
		return fournisseurService.findAll();
	}

	@Override
	public void delete(Integer id) {
		fournisseurService.delete(id);
		
	}

}
