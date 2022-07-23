package com.example.gestionStock.Validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;

import com.example.gestionStock.Dto.ArticleDto;


public class ArticleValidator {

	
	
	public static List<String>validate(ArticleDto articleDto){
	
		List<String>errors = new ArrayList<>();
		
		
		if(articleDto == null) {
			
			errors.add("Veuillez renseigner le code de l'article");
			errors.add("Veuillez renseigner la désignation de l'article");
			errors.add("Veuillez renseigner le prix unitaire HT de l'article");
			errors.add("Veuillez renseigner le taux tva de l'article");
			errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
			errors.add("Veuillez sélectionner la catégorie de l'article");
			errors.add("Veuillez sélectionner la catégorie de l'article");
			return errors;
			
			
		}
		
		
		
		
		if(!StringUtils.hasLength(articleDto.getCodeArticle())) {
			
			errors.add("Veuillez renseigner le code de l'article");
		}
		
		if(!StringUtils.hasLength(articleDto.getDesignation())) {
					
			errors.add("Veuillez renseigner la désignation de l'article");
		}
		
		if(articleDto.getPrixUNitaireHt() == null) {
			
			errors.add("Veuillez renseigner le prix unitaire HT de l'article");
		}
		
		if(articleDto.getTva() == null) {
			
			errors.add("Veuillez renseigner le taux tva de l'article");
		}
		
		
			if(articleDto.getPrixUNitaireLtc() == null) {
			
			errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
		}
		
	
			
		if(articleDto.getCategorie() == null) {
				
			errors.add("Veuillez sélectionner la catégorie de l'article");
		}	
			
		return errors;
			
	}
	
	
}
