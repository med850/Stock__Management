package com.example.gestionStock.Dto;

import java.util.List;



import com.example.gestionStock.Entity.Adresse;
import com.example.gestionStock.Entity.Client;
import com.example.gestionStock.Entity.CommandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {

	private Integer id;

	
	private String nom;
	
	
	private String prenom;
	
	private AdresseDto adresse;
	
	
	private String photo;
	
	
	private String email;
	
	
	private String tel;
	
	
	@JsonIgnore
	private List<CommandeClientDto>comdClient;
	
	
/*	public Client toEntity(ClientDto clientDto) {
		
		if(clientDto == null) {
			return null;
		}
		
		
		
		
	}*/
	
}
