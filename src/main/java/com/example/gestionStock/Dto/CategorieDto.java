package com.example.gestionStock.Dto;

import java.util.List;

import com.example.gestionStock.Entity.Categorie;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CategorieDto {

	private Integer id;

	
	private String codeCat;
	
	private String designation;

	
	private List<ArticleDto>articles;
	
	
	/*public CategorieDto fromEntity(Categorie categorie) {
		
		if(categorie == null) {
			return null;
		}else {
			return CategorieDto.builder().code(categorie.getCode())
					
		}
		
	}*/
	
}
