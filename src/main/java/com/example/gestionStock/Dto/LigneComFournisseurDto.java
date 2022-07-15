package com.example.gestionStock.Dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LigneComFournisseurDto {

	
	private Integer id;

	
	private ArticleDto article;
	

	private CommandeFournisseurDto commandeFournisseur;
	
	
	private BigDecimal quantite;
	
	
	private BigDecimal prixUnitaire;

	
	
}
