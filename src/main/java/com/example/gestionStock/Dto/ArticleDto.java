package com.example.gestionStock.Dto;

import java.math.BigDecimal;

import com.example.gestionStock.Entity.Categorie;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ArticleDto {

	
	private Integer id;

	private String codeArticle;
	

	private String designation;
	

	private BigDecimal prixUNitaireHt;
	

	private BigDecimal tva;
	

	private BigDecimal prixUNitaireLtc;
	
	

	private String photo;
	
	
	private CategorieDto categorie;
	
	
	
	
}
