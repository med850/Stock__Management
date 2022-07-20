package com.example.gestionStock.Dto;

import java.util.List;

import com.example.gestionStock.Entity.Fournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FournisseurDto {

	
	private Integer id;
	
	
	private String nom;
	
	
	private String prenom;
	
	private AdresseDto adresse;
	
	
	private String photo;
	
	
	private String email;
	
	
	private String tel;
	
	
	private Integer idEntreprise;
	
	@JsonIgnore
	private List<CommandeFournisseurDto>commandeFournisseurs;
	
	
	
	public static FournisseurDto fromEntity(Fournisseur fournisseur) {
		
		if(fournisseur == null) {
			
			return null;
		}
		
		return FournisseurDto.builder()
				.id(fournisseur.getId())
				.nom(fournisseur.getNom())
				.prenom(fournisseur.getPrenom())
				.adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
				.photo(fournisseur.getPhoto())
				.email(fournisseur.getEmail())
				.tel(fournisseur.getTel())
				.idEntreprise(fournisseur.getIdEntreprise())
				.build();
		
		
	}
	
	
	
	public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
		
		
		if(fournisseurDto == null) {
			
			return null;
		}
		
		Fournisseur fournisseur = new Fournisseur();
		
		fournisseur.setId(fournisseurDto.getId());
		fournisseur.setNom(fournisseurDto.getNom());
		fournisseur.setPrenom(fournisseurDto.getPrenom());
		fournisseur.setAdresse(AdresseDto.toEntity(fournisseurDto.getAdresse()));
		fournisseur.setPhoto(fournisseurDto.getPhoto());
		fournisseur.setEmail(fournisseurDto.getEmail());
		fournisseur.setTel(fournisseurDto.getTel());
		fournisseur.setIdEntreprise(fournisseurDto.getIdEntreprise());
		
		return fournisseur;
		
	}
	
	
	
}
