package com.example.gestionStock.Repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionStock.Entity.MvtStock;



public interface MvtStockRepository extends JpaRepository<MvtStock, Integer>{

}
