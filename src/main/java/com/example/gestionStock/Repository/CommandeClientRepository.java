package com.example.gestionStock.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionStock.Entity.CommandeClient;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer>{

	
	
	Optional<CommandeClient>findCommandeClientByCodes(String code);
	
}
