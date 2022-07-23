package com.example.gestionStock.Controller.Api;

import static com.example.gestionStock.Utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionStock.Dto.CommandeClientDto;

import io.swagger.annotations.Api;


@Api(APP_ROOT + "/commandesclients")
public interface CommandeClientApi {

	
	
	
	@PostMapping(APP_ROOT + "/commandesclients/create")
	ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto commandeClientDto);
	
	
	
	@GetMapping(APP_ROOT + "/commandesclients/{idCommandeClient}")
	ResponseEntity<CommandeClientDto>findById(@PathVariable("idCommandeClient") Integer id);
	
	
	@GetMapping(APP_ROOT + "/commandesclients/{codeCommandeClient}")
	ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);
	
	
	
	@GetMapping(APP_ROOT + "commandesclients/all")
	ResponseEntity<List<CommandeClientDto>> findAll();
	
	
	
	
	@DeleteMapping(APP_ROOT + "/commandesclients/delete/{idCommandeClient}")
	ResponseEntity delete(@PathVariable("idCommandeClient")Integer id);
	
	
	
	
	
	
}
