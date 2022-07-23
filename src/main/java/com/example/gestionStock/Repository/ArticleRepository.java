package com.example.gestionStock.Repository;


import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionStock.Entity.Article;



public interface ArticleRepository extends JpaRepository<Article, Integer>{

	
	Optional<Article> findByCodeArticle(String codeArticle);
	
	
	
	
	
	
}
