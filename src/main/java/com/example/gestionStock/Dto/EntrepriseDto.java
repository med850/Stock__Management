package com.example.gestionStock.Dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.ComponentScan;

import com.example.gestionStock.Entity.Entreprise;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {

	private Integer id;

	
	private String nom;
	
	
	private String description;
	
	
	private String codeFiscal;
	
	
	private String photo;
	
	
	private String email;
	
	
	private String tel;
	
	
	private String siteWeb;
	
	//private AdresseDto adresse;
	
	
	private Integer idEntreprise;
	
	@JsonIgnore
	private List<UsersDto>users;
	
	
	
	public static EntrepriseDto fromEntity(Entreprise entreprise) {
		
		
		if(entreprise == null ) {
			return null;
		}
		
		return EntrepriseDto.builder()
				.id(entreprise.getId())
				.nom(entreprise.getNom())
				.description(entreprise.getDescription())
				.codeFiscal(entreprise.getCodeFiscal())
				.photo(entreprise.getPhoto())
				.email(entreprise.getEmail())
				.tel(entreprise.getTel())
				.siteWeb(entreprise.getSiteWeb())
				.users(entreprise.getUsers() != null ?
						entreprise.getUsers().stream()
						.map(UsersDto::fromEntity)
						.collect(Collectors.toList()) : null
						).build();
		
	}
	
	
	
	public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
		
		if(entrepriseDto == null) {
			
			return null;
		}
		
		Entreprise entreprise = new Entreprise();
		
		entreprise.setId(entrepriseDto.getId());
		entreprise.setNom(entrepriseDto.getNom());
		entreprise.setDescription(entrepriseDto.getDescription());
		entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
		entreprise.setPhoto(entrepriseDto.getPhoto());
		entreprise.setEmail(entrepriseDto.getEmail());
		entreprise.setTel(entrepriseDto.getTel());
		entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
		
		return entreprise;
		
	}
}
