package com.example.gestionStock.Dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.example.gestionStock.Entity.User;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserDto {

	private Integer id;

	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	
	private Instant dateDeNaissance;
	
	
	private String motDePasse;
	
	
	private AdresseDto adresse;
	
	
	private String photo;
	
	

	private EntrepriseDto entreprise;



	private List<RolesDto>roles;

	
	public static UserDto fromEntity(User user) {
		
		if(user == null) {
			return null;
		}
		
		return UserDto.builder()
				.id(user.getId())
				.nom(user.getNom())
				.prenom(user.getPrenom())
				.email(user.getEmail())
				.motDePasse(user.getMotDePasse())
				.dateDeNaissance(user.getDateDeNaissance())
				.adresse(AdresseDto.fromEntity(user.getAdresse()))
				.photo(user.getPhoto())
				.entreprise(EntrepriseDto.fromEntity(user.getEntreprise()))
				.roles(
						user.getRoles() != null ?
						user.getRoles().stream()
						.map(RolesDto::fromEntity)
						.collect(Collectors.toList()) : null
						).build();
				
		
		
	}
	
	
}
