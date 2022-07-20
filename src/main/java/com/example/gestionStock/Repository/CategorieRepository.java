package com.example.gestionStock.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionStock.Entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer>{

	
	Optional<Categorie>findCategorieByCode(String code);
	
	
}
