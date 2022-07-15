package com.example.gestionStock.Dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneComClientDto {

	
	private Integer id;
	
	
	private ArticleDto article;
	
	
	private CommandeClientDto commandeClient;
	
	
	private BigDecimal quantite;
	
	
	private BigDecimal prixUnitaire;


	
}
