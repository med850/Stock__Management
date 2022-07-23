package com.example.gestionStock.Validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;

import com.example.gestionStock.Dto.ClientDto;



public class ClientValidator {

	
	public static List<String> validate(ClientDto clientDto){
		
		
		List<String> errors = new ArrayList<>();
		
		
		
		if(clientDto == null) {
			
			
			errors.add("Veuillez renseigner le nom de client...!");
			errors.add("Veuillez renseigner le prénom de client...!");
			errors.add("Veuillez renseigner l'email de client...!");
			errors.add("Veuillez renseigner le numéro de téléphone de client...!");
			
			return errors;
			
			
		}
		
		
		
		
		
		if(!StringUtils.hasLength(clientDto.getNom())) {
			
			errors.add("Veuillez renseigner le nom de client...!");
		}
		
		if(!StringUtils.hasLength(clientDto.getPrenom())) {
			
			errors.add("Veuillez renseigner le prénom de client...!");
		}
		
		
		
		if(!StringUtils.hasLength(clientDto.getEmail())) {
			
			errors.add("Veuillez renseigner l'email de client...!");
		}
		
		
		
		if(!StringUtils.hasLength(clientDto.getTel())) {
			
			errors.add("Veuillez renseigner le numéro de téléphone de client...!");
		}
		
		
		
		
		return errors;
	}
	
	
}
