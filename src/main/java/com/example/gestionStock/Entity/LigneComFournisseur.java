package com.example.gestionStock.Entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="ligneComFournisseur")

public class LigneComFournisseur extends AbstractEntity {

	
	
	
	
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;
	
	
	@ManyToOne
	@JoinColumn(name="idcomfournisseur")
	private CommandeFournisseur commandeFournisseur;
	
	
}