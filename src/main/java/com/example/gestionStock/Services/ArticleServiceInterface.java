package com.example.gestionStock.Services;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.example.gestionStock.Dto.ArticleDto;



public interface ArticleServiceInterface {

	
	
	ArticleDto save(ArticleDto articleDto);
	
	ArticleDto findById(Integer id);
	
	ArticleDto findByCodeArticle(String codeArticle);
	
	List<ArticleDto> findAll();
	
	void delete(Integer id);
	
	
}
