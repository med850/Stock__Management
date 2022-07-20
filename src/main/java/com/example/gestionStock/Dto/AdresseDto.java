package com.example.gestionStock.Dto;

import com.example.gestionStock.Entity.Adresse;

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



	public static AdresseDto fromEntity(Adresse adresse) {
		
		if(adresse == null) {
			return null;
		}
		
		return AdresseDto.builder()
				.adr1(adresse.getAdr1())
				.adr2(adresse.getAdr2())
				.codePostal(adresse.getCodePostal())
				.ville(adresse.getVille())
				.pays(adresse.getPays())
				.build();
		
	}
	
	
	public static Adresse toEntity(AdresseDto adresseDto) {
		
		if(adresseDto == null) {
			return null;
		}
		
		Adresse adr = new Adresse();
		adr.setAdr1(adresseDto.getAdr1());
		adr.setAdr2(adresseDto.getAdr2());
		adr.setCodePostal(adresseDto.getCodePostal());
		adr.setVille(adresseDto.getVille());
		adr.setPays(adresseDto.getPays());
		return adr;
		
	}
	
	
	
	
	
	
	
	


}
