package com.example.gestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionStock.Entity.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Integer, Entreprise>{

}
