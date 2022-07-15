package com.example.gestionStock.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="entreprise")
public class Entreprise extends AbstractEntity{

	
	@Column(name="nom")
	private String nom;
	
	
	
	
	
	
}


