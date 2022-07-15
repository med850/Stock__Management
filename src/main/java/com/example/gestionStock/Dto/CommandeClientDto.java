package com.example.gestionStock.Dto;

import java.time.Instant;
import java.util.List;



import com.example.gestionStock.Entity.Client;
import com.example.gestionStock.Entity.LigneComClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDto {

	
	private Integer id;

	
	private String code;
	
	private Instant dateCommande;
	

	private ClientDto client;
	
	

	private List<LigneComClientDto> ligneCommandeClient;
	
	
	
}
