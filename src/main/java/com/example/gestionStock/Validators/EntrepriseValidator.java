package com.example.gestionStock.Validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;

import com.example.gestionStock.Dto.EntrepriseDto;


public class EntrepriseValidator {

	
public static List<String> validate(EntrepriseDto entrepriseDto){
		
		
		List<String> errors = new ArrayList<>();
		
		
		
		if(entrepriseDto == null) {
			
			
			errors.add("Veuillez renseigner le nom de founrnisseur...!");
			errors.add("Veuillez renseigner le prénom de founrnisseur...!");
			errors.add("Veuillez renseigner l'email de founrnisseur...!");
			errors.add("Veuillez renseigner le numéro de téléphone de founrnisseur...!");
			
			return errors;
			
			
		}
		
		
	if(!StringUtils.hasLength(entrepriseDto.getNom())) {
			
			errors.add("Veuillez renseigner le nom de l'entreprise...!");
		}
		
		
		return errors;
	
}
}
