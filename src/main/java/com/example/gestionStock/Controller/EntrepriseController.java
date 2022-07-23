package com.example.gestionStock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionStock.Controller.Api.EntrepriseApi;
import com.example.gestionStock.Dto.EntrepriseDto;
import com.example.gestionStock.Services.EntrepriseServiceInterface;




@RestController
public class EntrepriseController implements EntrepriseApi{

	
	
	private EntrepriseServiceInterface entrepriseServiceInterface;
	
	
	
	
	
	
	@Autowired
	public EntrepriseController(EntrepriseServiceInterface entrepriseServiceInterface) {
		this.entrepriseServiceInterface = entrepriseServiceInterface;
	}

	@Override
	public ResponseEntity<EntrepriseDto> save(EntrepriseDto entrepriseDto) {
		
		return ResponseEntity.ok(entrepriseServiceInterface.save(entrepriseDto));
	}
	
	@Override
	public ResponseEntity<EntrepriseDto> findById(Integer id) {
		
		return ResponseEntity.ok(entrepriseServiceInterface.findById(id));
	}

	@Override
	public ResponseEntity<List<EntrepriseDto>> findAll() {
		
		return ResponseEntity.ok(entrepriseServiceInterface.findAll());
	}

	@Override
	public ResponseEntity delete(Integer id) {
		entrepriseServiceInterface.delete(id);
		return ResponseEntity.ok().build();
		
	}

}
