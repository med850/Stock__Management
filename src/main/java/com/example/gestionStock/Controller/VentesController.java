package com.example.gestionStock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionStock.Controller.Api.VentesApi;
import com.example.gestionStock.Dto.VentesDto;
import com.example.gestionStock.Services.VenteServiceInterface;


@RestController
public class VentesController implements VentesApi{

	
	
	private VenteServiceInterface venteService;
	
	@Autowired
	public VentesController(VenteServiceInterface venteService) {
		this.venteService = venteService;
	}

	@Override
	public VentesDto save(VentesDto venteDto) {
		
		return venteService.save(venteDto);
	}

	@Override
	public VentesDto findById(Integer id) {
		
		return venteService.findById(id);
	}

	@Override
	public VentesDto findByCode(String code) {
		
		return venteService.findByCode(code);
	}

	@Override
	public List<VentesDto> findAll() {
		
		return venteService.findAll();
	}

	@Override
	public void delete(Integer id) {
		venteService.delete(id);
		
	}

}
