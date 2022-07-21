package com.example.gestionStock.Dto;

import java.time.Instant;
import java.util.List;



import com.example.gestionStock.Entity.Client;
import com.example.gestionStock.Entity.CommandeClient;
import com.example.gestionStock.Entity.LigneComClient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDto {

	
	private Integer id;

	
	private String code;
	
	private Instant dateCommande;
	

	private ClientDto client;
	
	//private Integer idEntreprise;
	
	
	
	private List<LigneComClientDto> ligneCommandeClient;
	
	
	public static CommandeClientDto fromEntity(CommandeClient commandeClient){
		  if(commandeClient == null){
		    return null;
		 }
		  return CommandeClientDto.builder()
		      .id(commandeClient.getId())
		      .code(commandeClient.getCode())
		      .dateCommande(commandeClient.getDateCommande())
		      .client(ClientDto.fromEntity(commandeClient.getClient()))
		      .build();
	}

	
	
	
	public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
		
		
		if(commandeClientDto == null) {
			return null;
		}
		
		CommandeClient commandeClient = new CommandeClient();
		
		commandeClient.setId(commandeClientDto.getId());
		commandeClient.setCode(commandeClientDto.getCode());
		commandeClient.setDateCommande(commandeClientDto.getDateCommande());
		//commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClient()));
		
		
		return commandeClient;
	}
}
	
	
