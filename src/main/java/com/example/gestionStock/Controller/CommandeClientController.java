package com.example.gestionStock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionStock.Controller.Api.CommandeClientApi;
import com.example.gestionStock.Dto.CommandeClientDto;
import com.example.gestionStock.Services.CommandeClientServiceInterface;



@RestController
public class CommandeClientController implements CommandeClientApi{

	
	
	private CommandeClientServiceInterface commandeClientService;
	
	
	
	
	@Autowired
	public CommandeClientController(CommandeClientServiceInterface commandeClientService) {
		this.commandeClientService = commandeClientService;
	}

	@Override
	public ResponseEntity<CommandeClientDto> save(CommandeClientDto commandeClientDto) {
	
		return ResponseEntity.ok(commandeClientService.save(commandeClientDto));
	}

	@Override
	public ResponseEntity<CommandeClientDto> findById(Integer id) {
	
		return ResponseEntity.ok(commandeClientService.findById(id));
	}

	@Override
	public ResponseEntity<CommandeClientDto> findByCode(String code) {
		
		return ResponseEntity.ok(commandeClientService.findByCode(code));
	}

	@Override
	public ResponseEntity<List<CommandeClientDto>> findAll() {
		
		return ResponseEntity.ok(commandeClientService.findAll());
	}

	@Override
	public ResponseEntity delete(Integer id) {
		
		commandeClientService.delete(id);
		return ResponseEntity.ok().build();
	}

}
