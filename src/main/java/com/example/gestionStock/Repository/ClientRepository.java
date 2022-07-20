package com.example.gestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionStock.Entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
