package com.example.gestionStock.Validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;

import com.example.gestionStock.Dto.CategorieDto;


public class CategorieValidator {

	public static List<String> validate(CategorieDto categorieDto){
		
		List<String> errors = new ArrayList<>();
		
		
		if(categorieDto == null || !StringUtils.hasLength(categorieDto.getCode())) {
			
			errors.add("code de la catégorie est invalide, veuillez renseigner ...!");
		}
		
		return errors;
		
		
		
		
	}
	
	
}
