package com.example.gestionStock.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDto {


	private String adr1;
	
	private String adr2;
	
	private String ville;
	
	private String codePostal;
	
	private String pays;
}
