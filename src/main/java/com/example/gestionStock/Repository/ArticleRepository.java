package com.example.gestionStock.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionStock.Entity.Article;

public interface ArticleRepository extends JpaRepository<Integer, Article>{

	
	//Article findByCodeArticle(String code);
	
	
	
}
