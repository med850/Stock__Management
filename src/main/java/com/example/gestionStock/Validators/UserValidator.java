package com.example.gestionStock.Validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;

import com.example.gestionStock.Dto.UsersDto;



public class UserValidator {

	
	public static List<String>validate(UsersDto userDto){
		
		
		
		List<String>errors = new ArrayList<>();
		
		
		
		if(userDto == null) {
			
			errors.add("Veuillez renseigner le nom d'utilisateur");
			errors.add("Veuillez renseigner le prénom d'utilisateur");
			errors.add("Veuillez renseigner le mot de passe d'utilisateur");
			errors.add("Veuillez renseigner l'adresse d'utilisateur");
			return errors;

		}
		
		
		
		if(!StringUtils.hasLength(userDto.getNom())) {
			
			errors.add("Nom d'utilisateur est invalide, veuillez  renseigner...!");
			}
		if(!StringUtils.hasLength(userDto.getPrenom())) {
				
				errors.add("Prénom d'utilisateur est invalide, veuillez  renseigner...!");
			}
		
		if(!StringUtils.hasLength(userDto.getEmail())) {
			
			errors.add("L'email d'utilisateur est invalide, veuillez  renseigner...!");
		}
		
		if(!StringUtils.hasLength(userDto.getMotDePasse())) {
			
			errors.add("Mot de passe est invalide, veuillez  renseigner...!");
		}
		
		if(userDto.getDateDeNaissance() == null) {
			
			errors.add("La date de naissance est invalide, veuillez  renseigner...!");

		}
		
		if(userDto.getAdresse() == null) {
			
			errors.add("Veuillez  renseigner l'adresse d'utilisateur...!");

		}else {
		
		if(!StringUtils.hasLength(userDto.getAdresse().getAdr1())) {
			
			errors.add("Le champ adresse 1  est obligatoire");
		}
		
		if(!StringUtils.hasLength(userDto.getAdresse().getVille())) {
			
			errors.add("Le champ ville est obligatoire");
		}
		
		if(!StringUtils.hasLength(userDto.getAdresse().getCodePostal())) {
			
			errors.add("Le champ code postal est obligatoire");
		}
		
		if(!StringUtils.hasLength(userDto.getAdresse().getPays())) {
			
			errors.add("Le champ pays est obligatoire");
		}
		
	}
		
		return errors;
	}
	
	
	
}
