package com.example.gestionStock.Repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionStock.Entity.LigneComFournisseur;



public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneComFournisseur, Integer>{

}
