package com.example.gestionStock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@ComponentScan(basePackages= {"com.example.gestionStock.Config"+"com.example.gestionStock.Controller"+"com.example.gestionStock.Controller.Api"
+"com.example.gestionStock.Dto"+"com.example.gestionStock.Exception"+"com.example.gestionStock.Handlers"+"com.example.gestionStock.Repository"
+"com.example.gestionStock.Services"+"com.example.gestionStock.Services.Implements"+"com.example.gestionStock.Utils"
+"com.example.gestionStock.Validators"})
@SpringBootApplication
@EnableJpaAuditing
public class GestionStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionStockApplication.class, args);
	}

}
