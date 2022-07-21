package com.example.gestionStock.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionStock.Entity.CommandeFournisseur;


public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer>{

	
	
	Optional<CommandeFournisseur>findCommandeFournisseurByCodes(String codes);

	
}
