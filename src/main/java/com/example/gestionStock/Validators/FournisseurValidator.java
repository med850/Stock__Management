package com.example.gestionStock.Validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;


import com.example.gestionStock.Dto.FournisseurDto;


public class FournisseurValidator {

	
	
public static List<String> validate(FournisseurDto fournisseurDto){
		
		
		List<String> errors = new ArrayList<>();
		
		
		
		if(fournisseurDto == null) {
			
			
			errors.add("Veuillez renseigner le nom de founrnisseur...!");
			errors.add("Veuillez renseigner le prénom de founrnisseur...!");
			errors.add("Veuillez renseigner l'email de founrnisseur...!");
			errors.add("Veuillez renseigner le numéro de téléphone de founrnisseur...!");
			
			return errors;
			
			
		}
		
		
		
		
		
		if(!StringUtils.hasLength(fournisseurDto.getNom())) {
			
			errors.add("Veuillez renseigner le nom de founrnisseur...!");
		}
		
		if(!StringUtils.hasLength(fournisseurDto.getPrenom())) {
			
			errors.add("Veuillez renseigner le prénom de founrnisseur...!");
		}
		
		
		
		if(!StringUtils.hasLength(fournisseurDto.getEmail())) {
			
			errors.add("Veuillez renseigner l'email de founrnisseur...!");
		}
		
		
		
		if(!StringUtils.hasLength(fournisseurDto.getTel())) {
			
			errors.add("Veuillez renseigner le numéro de téléphone de founrnisseur...!");
		}
		
		
		
		
		return errors;
	}
	
	
	
	
}
