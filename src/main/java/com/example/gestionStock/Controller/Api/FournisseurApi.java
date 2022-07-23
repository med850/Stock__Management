package com.example.gestionStock.Controller.Api;

import static com.example.gestionStock.Utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.gestionStock.Dto.FournisseurDto;

import io.swagger.annotations.Api;


@Api(APP_ROOT + "fournisseurs")
public interface FournisseurApi {

	
	
	@PostMapping(value = APP_ROOT + "/fournisseurs/create")
	FournisseurDto save(@RequestBody FournisseurDto fournisseurDto);
	
	@GetMapping(value = APP_ROOT + "/fournisseurs/{idFournisseur}")
	FournisseurDto findById(@PathVariable("idFournisseur")Integer id);
	
	@GetMapping(value = APP_ROOT + "/fournisseurs/all")
	List<FournisseurDto>findAll();
	
	
	
	@DeleteMapping(value = APP_ROOT + "/fournisseur/delete/{idFournisseur}")
	void delete(@PathVariable("idFournisseur")Integer id);
	
	
	
}
