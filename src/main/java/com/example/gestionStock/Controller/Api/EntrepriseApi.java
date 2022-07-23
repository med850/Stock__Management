package com.example.gestionStock.Controller.Api;

import static com.example.gestionStock.Utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.gestionStock.Dto.EntrepriseDto;

import io.swagger.annotations.Api;


@Api(APP_ROOT + "/entreprises")
public interface EntrepriseApi {

	
	
	@PostMapping(value = APP_ROOT + "/entreprises/create")
	ResponseEntity<EntrepriseDto> save(@RequestBody EntrepriseDto entrepriseDto);
	
	@GetMapping(value = APP_ROOT + "/entreprises/{idEntreprise}")
	ResponseEntity<EntrepriseDto> findById(@PathVariable("idEntreprise") Integer id);
	
	@GetMapping(value = APP_ROOT + "/entreprises/all")
	ResponseEntity<List<EntrepriseDto>>findAll();
	
	
	@DeleteMapping(value = APP_ROOT + "/entreprises/delete/{idEntreprise}")
	ResponseEntity delete(@PathVariable("idEntreprise") Integer id);
	
	
	
	
	
}
