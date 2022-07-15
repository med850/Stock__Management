package com.example.gestionStock.Dto;

import java.time.Instant;
import java.util.List;

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

	
	
}
