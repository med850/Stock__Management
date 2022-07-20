package com.example.gestionStock.Dto;

import java.math.BigDecimal;

import com.example.gestionStock.Entity.LigneVente;

import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class LigneVenteDto {

	
	private Integer id;


	private VentesDto vente;
	
	
	private BigDecimal quantite;
	
	
	private BigDecimal prixUnitaire;
	
	
	//private Integer idEntreprise;
	
	private ArticleDto article;
	
	
	
	
	public static LigneVenteDto fromEntity(LigneVente ligneVente) {
		
		if(ligneVente == null) {
			
			return null;
			
		}
		
		
		return LigneVenteDto.builder()
				.id(ligneVente.getId())
				.vente(VentesDto.fromEntity(ligneVente.getVente()))
				.quantite(ligneVente.getQuantite())
				.prixUnitaire(ligneVente.getPrixUnitaire())
				.article(ArticleDto.fromEntity(ligneVente.getArticle()))
				.build();
		
		
	}
	
	
	
	
	public static LigneVente toEntity(LigneVenteDto ligneVenteDto) {
		
		if(ligneVenteDto == null) {
			
			return null;
		}
		
		LigneVente ligneVente = new LigneVente();
		
		ligneVente.setId(ligneVenteDto.getId());
		ligneVente.setVente(VentesDto.toEntity(ligneVenteDto.getVente()));
		ligneVente.setQuantite(ligneVenteDto.getQuantite());
		ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
		ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticle()));
		
		return ligneVente;
	}
	
	
	
	
	
}
