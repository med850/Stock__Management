package com.example.gestionStock.Repository;

import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionStock.Entity.Ventes;



public interface VentesRepository extends JpaRepository<Ventes, Integer>{
	
	
	
	
	Optional<Ventes>findVentesByCode(String code);

}
