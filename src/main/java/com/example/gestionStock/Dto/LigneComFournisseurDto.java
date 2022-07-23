package com.example.gestionStock.Dto;

import java.math.BigDecimal;

import org.springframework.context.annotation.ComponentScan;

import com.example.gestionStock.Entity.LigneComClient;
import com.example.gestionStock.Entity.LigneComFournisseur;

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
	
	
	private Integer idEntreprise;

	
	
	
public static LigneComFournisseurDto fromEntity(LigneComFournisseur lignCommFournisseur) {
		
		if(lignCommFournisseur == null) {
			
			return null;
		}
		
		return LigneComFournisseurDto.builder()
				.id(lignCommFournisseur.getId())
				.article(ArticleDto.fromEntity(lignCommFournisseur.getArticle()))
				.commandeFournisseur(CommandeFournisseurDto.fromEntity(lignCommFournisseur.getCommandeFournisseur()))
				.quantite(lignCommFournisseur.getQuantite())
				.prixUnitaire(lignCommFournisseur.getPrixUnitaire())
				.idEntreprise(lignCommFournisseur.getIdEntreprise())
				.build();
	}
	
	


public static LigneComFournisseur toEntity(LigneComFournisseurDto lignCommFournisseurDto) {
	
	
	if(lignCommFournisseurDto == null) {
		
		return null;
	}
	
	LigneComFournisseur lignCommFournisseur = new LigneComFournisseur();
	
	lignCommFournisseur.setId(lignCommFournisseurDto.getId());
	lignCommFournisseur.setArticle(ArticleDto.toEntity(lignCommFournisseurDto.getArticle()));
	lignCommFournisseur.setCommandeFournisseur(CommandeFournisseurDto.toEntity(lignCommFournisseurDto.getCommandeFournisseur()));
	lignCommFournisseur.setQuantite(lignCommFournisseurDto.getQuantite());
	lignCommFournisseur.setPrixUnitaire(lignCommFournisseurDto.getPrixUnitaire());
	lignCommFournisseur.setIdEntreprise(lignCommFournisseurDto.getIdEntreprise());
	
	return lignCommFournisseur;
	
	
	
}
	
	
}
