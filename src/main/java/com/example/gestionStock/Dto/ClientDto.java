package com.example.gestionStock.Dto;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

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
	
	//private Integer idEntreprise;
	
	
	@JsonIgnore
	private List<CommandeClientDto>comdClient;
	
	
	public static ClientDto fromEntity(Client client) {
		
		if(client == null) {
			return null;
		}
		
		return ClientDto.builder()
				.id(client.getId())
				.nom(client.getNom())
				.prenom(client.getPrenom())
				.adresse(AdresseDto.fromEntity(client.getAdresse()))
				.photo(client.getPhoto())
				.email(client.getEmail())
				.tel(client.getTel())
				.build();
				
		
		
		
		
	}
	
	
	
	public static Client toEntity(ClientDto clientDto) {
		
			if(clientDto == null) {
				
				return null;
				
			}
			
			Client client = new Client();
		
			client.setId(clientDto.getId());
			client.setNom(clientDto.getNom());
			client.setPrenom(clientDto.getPrenom());
			client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));
			client.setPhoto(clientDto.getPhoto());
			client.setEmail(clientDto.getEmail());
			client.setTel(clientDto.getTel());
			
			return client;
		
	}
	
	
	
	
}
