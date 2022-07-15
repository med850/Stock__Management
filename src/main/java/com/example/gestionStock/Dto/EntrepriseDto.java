package com.example.gestionStock.Dto;

import java.util.List;

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
	
	
	
	
	
	
	
}
