package com.example.gestionStock.Dto;

import java.math.BigDecimal;

import org.springframework.context.annotation.ComponentScan;

import com.example.gestionStock.Entity.LigneComClient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LigneComClientDto {

	
	private Integer id;
	
	
	private ArticleDto article;
	
	@JsonIgnore
	private CommandeClientDto commandeClient;
	
	
	private BigDecimal quantite;
	
	
	private BigDecimal prixUnitaire;
	
	
	//private Integer idEntreprise;


	
	public static LigneComClientDto fromEntity(LigneComClient lignCommClient) {
		
		if(lignCommClient == null) {
			
			return null;
		}
		
		return LigneComClientDto.builder()
				.id(lignCommClient.getId())
				.article(ArticleDto.fromEntity(lignCommClient.getArticle()))
				//.commandeClient(CommandeClientDto.fromEntity(lignCommClient.getCommandeClient()))
				.quantite(lignCommClient.getQuantite())
				.prixUnitaire(lignCommClient.getPrixUnitaire())
				.build();
	}
	
	
	
	public static LigneComClient toEntity(LigneComClientDto lignCommClientDto) {
		
		
		if(lignCommClientDto == null) {
			
			return null;
		}
		
		LigneComClient lignCommClient = new LigneComClient();
		
		lignCommClient.setId(lignCommClientDto.getId());
		lignCommClient.setArticle(ArticleDto.toEntity(lignCommClientDto.getArticle()));
		//lignCommClient.setCommandeClient(CommandeClientDto.toEntity(lignCommClientDto.getCommandeClient()));
		lignCommClient.setQuantite(lignCommClientDto.getQuantite());
		lignCommClient.setPrixUnitaire(lignCommClientDto.getPrixUnitaire());
		
		return lignCommClient;
		
		
		
	}
	
}
