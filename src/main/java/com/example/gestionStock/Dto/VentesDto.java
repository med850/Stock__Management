package com.example.gestionStock.Dto;

import java.time.Instant;
import java.util.List;

import com.example.gestionStock.Entity.Ventes;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class VentesDto {

	private Integer id;


	private String code;
	
	
	private Instant dateVente;
	
	
	private String commentaire;
	
	
	//private Integer idEntreprise;
	
	
	private List<LigneVenteDto>ligneVente;
	
	
	
	public static VentesDto fromEntity(Ventes vente) {
		
		if(vente == null) {
			
			return null;
		}
		
		return VentesDto.builder()
				.id(vente.getId())
				.code(vente.getCode())
				.commentaire(vente.getCommentaire())
				.build();
		
	}

	
	
	
	public static Ventes toEntity(VentesDto venteDto) {
		
		
		if(venteDto == null) {
			
			return null;
		}
		
		Ventes vente = new Ventes();
		
		vente.setId(venteDto.getId());
		vente.setCode(venteDto.getCode());
		vente.setCommentaire(venteDto.getCommentaire());
		
		return vente;
		
	}
	
	
	
}
