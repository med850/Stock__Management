package com.example.gestionStock.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Embeddable
public class Adresse {
	
	
	@Column(name="adresse1")
	private String adr1;
	
	@Column(name="adresse2")
	private String adr2;
	
	@Column(name="ville")
	private String ville;
	
	@Column(name="codepostal")
	private String codePostal;
	
	@Column(name="pays")
	private String pays;

}