package com.example.gestionStock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@ComponentScan("com.example.gestionStock")
@SpringBootApplication
@EnableJpaAuditing
public class GestionStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionStockApplication.class, args);
	}

}
