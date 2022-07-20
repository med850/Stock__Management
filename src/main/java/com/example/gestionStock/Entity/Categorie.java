package com.example.gestionStock.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity
@Table(name="categorie")
public class Categorie extends AbstractEntity{
	
	
	
	@Column(name="codecategorie")
	private String code;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="idEntreprise")
	private Integer idEntreprise;

	
	@OneToMany(mappedBy="categorie")
	private List<Article>articles;
	
}
