package com.example.gestionStock.Dto;

import java.util.List;



import com.example.gestionStock.Entity.Adresse;
import com.example.gestionStock.Entity.CommandeClient;

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
	
	
	private List<CommandeClientDto>comdClient;
	
	
	
}
