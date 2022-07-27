package com.example.gestionStock.Repository;


import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.gestionStock.Entity.Users;



public interface UsersRepository extends JpaRepository<Users, Integer>{

	
	Optional<Users> findUserByEmail(@Param("email")String email);
	
	
	
}
