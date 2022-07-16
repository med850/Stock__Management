package com.example.gestionStock.Dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.gestionStock.Entity.Entreprise;

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
	
	
	private List<UserDto>users;
	
	
	
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
						.map(UserDto::fromEntity)
						.collect(Collectors.toList()) : null
						).build();
		
	}
	
	
	
	
}
