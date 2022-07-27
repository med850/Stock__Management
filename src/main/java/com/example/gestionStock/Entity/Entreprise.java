package com.example.gestionStock.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Table(name="entreprise")
public class Entreprise extends AbstractEntity{

	
	@Column(name="nom")
	private String nom;
	
	
	@Column(name= "description")
	private String description;
	
	
	@Column(name ="codefiscal")
	private String codeFiscal;
	
	
	@Column(name = "photo")
	private String photo;
	
	
	@Column(name = "email")
	private String email;
	
	
	@Column(name = "tel")
	private String tel;
	
	
	@Column(name = "siteweb")
	private String siteWeb;
	

	
	
	@OneToMany(mappedBy = "entreprise")
	private List<Users>users;
	
	
	
	
	
	
	
}


