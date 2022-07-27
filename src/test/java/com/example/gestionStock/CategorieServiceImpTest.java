package com.example.gestionStock;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.gestionStock.Dto.CategorieDto;
import com.example.gestionStock.Services.CategorieServiceInterface;



@RunWith(SpringRunner.class)
@SpringBootTest
class CategorieServiceImpTest {

	
	@Autowired
	private CategorieServiceInterface catService;
	
	
	@Test
	public void shouldSaveCategorieWithSuccess() {
		
		CategorieDto expectedCategorie = CategorieDto.builder()
				.code("cat test")
				.designation("test design")
				.idEntreprise(1)
				.build();
		
		CategorieDto saveCat = catService.save(expectedCategorie);
		
		
		assertNotNull(saveCat);
		assertNotNull(saveCat.getId());
		assertEquals(expectedCategorie.getCode(), saveCat.getCode());
		assertEquals(expectedCategorie.getDesignation(), saveCat.getDesignation());
		assertEquals(expectedCategorie.getIdEntreprise(), saveCat.getIdEntreprise());


		
	}
}
