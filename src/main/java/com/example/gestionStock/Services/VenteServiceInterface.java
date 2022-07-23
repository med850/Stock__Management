package com.example.gestionStock.Services;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.example.gestionStock.Dto.VentesDto;

public interface VenteServiceInterface {

	
	VentesDto save(VentesDto venteDto);
	
	VentesDto findById(Integer id);
	
	VentesDto findByCode(String code);
	
	List<VentesDto> findAll();
	
	void delete(Integer id);
	
	
	
}
