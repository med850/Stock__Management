package com.example.gestionStock.Controller.Api;

import static com.example.gestionStock.Utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.gestionStock.Dto.VentesDto;

import io.swagger.annotations.Api;


@Api(APP_ROOT + "/ventes")
public interface VentesApi {

	
	@PostMapping(value = APP_ROOT + "/ventes/create")
	VentesDto save(@RequestBody VentesDto venteDto);
	
	
	@GetMapping(value = APP_ROOT + "/ventes/{idVente}")
	VentesDto findById(@PathVariable("idVente") Integer id);
	
	
	
	@GetMapping(value = APP_ROOT + "/ventes/{codeVente}")
	VentesDto findByCode(@PathVariable("codeVente")String code);
	
	
	@GetMapping(value = APP_ROOT + "/ventes/all")
	List<VentesDto> findAll();
	
	
	@DeleteMapping(value = APP_ROOT + "/ventes/delete/{idVente}")
	void delete(@PathVariable("idVente")Integer id);
	
	
}
