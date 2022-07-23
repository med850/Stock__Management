package com.example.gestionStock.Controller.Api;

import static com.example.gestionStock.Utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.gestionStock.Dto.CommandeFournisseurDto;

import io.swagger.annotations.Api;

@Api(APP_ROOT + "/commandesfournisseurs")
public interface CommandeFournisseurApi {

	
	
	
	
	@PostMapping(APP_ROOT + "/commandesfournisseurs/create")
	ResponseEntity<CommandeFournisseurDto> save(@RequestBody CommandeFournisseurDto commandeFournisseurDto);
	
	
	@GetMapping(APP_ROOT + "/commandesfournisseurs/{idCommandeFournisseur}")
	ResponseEntity<CommandeFournisseurDto> findById(@PathVariable("idCommandeFournisseur") Integer id);
	
	
	@GetMapping(APP_ROOT + "/commandesfournisseurs/{codeCommandeFournisseur}")
	ResponseEntity<CommandeFournisseurDto> findByCode(@PathVariable("codeCommandeFournisseur") String codes);
	
	
	
	@GetMapping(value = APP_ROOT + "/commandesfournisseurs/all")
	ResponseEntity<List<CommandeFournisseurDto>> findAll();
	
	@DeleteMapping(value = APP_ROOT + "/commandesfournisseurs/delete/{idCommandeFournisseur}")
	ResponseEntity delete(@PathVariable("idCommandeFournisseur") Integer id);
	
	
	
	
	
	
}
