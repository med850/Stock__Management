package com.example.gestionStock.Repository;

import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionStock.Entity.CommandeClient;




public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer>{

	
	
	Optional<CommandeClient>findCommandeClientByCode(String code);
	
}
