package com.example.gestionStock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionStock.Controller.Api.ArticleApi;
import com.example.gestionStock.Dto.ArticleDto;
import com.example.gestionStock.Services.ArticleServiceInterface;

@RestController
public class ArticleController implements ArticleApi{

	
	
	private ArticleServiceInterface articleService;
	
	
	/*
	public void setArticleService(ArticleServiceInterface articleService) {
		
		this.articleService = articleService;
		
	}*/
	
	@Autowired
	public ArticleServiceInterface getArticleService() {
		
		return articleService;
	}
	
	
	@Autowired
	public ArticleController(ArticleServiceInterface articleService) {
		
		this.articleService = articleService;
		
	}
	
	
	
	@Override
	public ArticleDto save(ArticleDto articleDto) {
		
		return articleService.save(articleDto);
	}

	@Override
	public ArticleDto findById(Integer id) {
		
		return articleService.findById(id);
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		
		return articleService.findByCodeArticle(codeArticle);
	}

	@Override
	public List<ArticleDto> findAll() {
		
		return articleService.findAll();
	}

	@Override
	public void delete(Integer id) {
		articleService.delete(id);
		
	}

	
	
	
	
}
