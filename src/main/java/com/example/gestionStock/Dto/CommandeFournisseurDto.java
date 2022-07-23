package com.example.gestionStock.Dto;

import java.time.Instant;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.example.gestionStock.Entity.CommandeFournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class CommandeFournisseurDto {

	
	private Integer id;
	
	
	private String codes;
	

	private Instant dateCommande;
	
	

	private FournisseurDto fournisseur;
	
	
	private Integer idEntreprise;
	
	

	private List<LigneComFournisseurDto> ligneCommandeFournisseur;
	
	
	
	public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
		
		if(commandeFournisseur == null) {
			
			return null;
		}
		
		return CommandeFournisseurDto.builder()
				.id(commandeFournisseur.getId())
				.codes(commandeFournisseur.getCodes())
				.dateCommande(commandeFournisseur.getDateCommande())
				.fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
				.idEntreprise(commandeFournisseur.getIdEntreprise())
				.build();
		
	}
	
	
	
	
	public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
		
		
		if(commandeFournisseurDto == null) {
			
			return null;
		}
		
		CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
		
		commandeFournisseur.setId(commandeFournisseurDto.getId());
		commandeFournisseur.setCodes(commandeFournisseurDto.getCodes());
		commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
		commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));
		commandeFournisseur.setIdEntreprise(commandeFournisseurDto.getIdEntreprise());
		
		return commandeFournisseur;
		
		
	}
	
}
