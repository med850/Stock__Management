package com.example.gestionStock.Entity;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="user")
public class User extends AbstractEntity {

	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "email")
	private String email;
	
	
	@Column(name = "datedenaissance")
	private Instant dateDeNaissance;
	
	
	@Column(name = "motdepasse")
	private String motDePasse;
	
	
	@Embedded
	private Adresse adresse;
	
	
	@Column(name = "photo")
	private String photo;
	
	
	@ManyToOne
	@JoinColumn(name = "identreprise")
	private Entreprise entreprise;



	@OneToMany(mappedBy="user")
	private List<Roles>roles;


	
}










