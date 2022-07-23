package com.example.gestionStock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionStock.Controller.Api.CommandeFournisseurApi;
import com.example.gestionStock.Dto.CommandeFournisseurDto;
import com.example.gestionStock.Services.CategorieServiceInterface;
import com.example.gestionStock.Services.CommandeFournisseurServiceInterface;



@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi{

	
	
	private CommandeFournisseurServiceInterface commandeFournisseurService;
	
	
	
	
	@Autowired
	public CommandeFournisseurController(CommandeFournisseurServiceInterface commandeFournisseurService) {
		this.commandeFournisseurService = commandeFournisseurService;
	}

	@Override
	public ResponseEntity<CommandeFournisseurDto> save(CommandeFournisseurDto commandeFournisseurDto) {
		
		return ResponseEntity.ok(commandeFournisseurService.save(commandeFournisseurDto));
	}

	@Override
	public ResponseEntity<CommandeFournisseurDto> findById(Integer id) {
		
		return ResponseEntity.ok(commandeFournisseurService.findById(id));
	}

	@Override
	public ResponseEntity<CommandeFournisseurDto> findByCode(String codes) {
		
		return ResponseEntity.ok(commandeFournisseurService.findByCode(codes));
	}

	@Override
	public ResponseEntity<List<CommandeFournisseurDto>> findAll() {
		
		return ResponseEntity.ok(commandeFournisseurService.findAll());
	}

	@Override
	public ResponseEntity delete(Integer id) {
		
		
		commandeFournisseurService.delete(id);
		return ResponseEntity.ok().build();
	}

}
