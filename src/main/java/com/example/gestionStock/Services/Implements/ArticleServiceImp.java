package com.example.gestionStock.Services.Implements;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.gestionStock.Dto.ArticleDto;
import com.example.gestionStock.Entity.Article;
import com.example.gestionStock.Exception.EntityNotFoundException;
import com.example.gestionStock.Exception.ErrorCodes;
import com.example.gestionStock.Exception.InvalidEntityException;
import com.example.gestionStock.Repository.ArticleRepository;
import com.example.gestionStock.Services.ArticleServiceInterface;
import com.example.gestionStock.Validators.ArticleValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleServiceImp implements ArticleServiceInterface{

	
	
	private ArticleRepository articleRepository;
	
	
	@Autowired
	public ArticleServiceImp(ArticleRepository articleRepository) {
		
		
		this.articleRepository = articleRepository;
		
	}
	
	
	@Override
	public ArticleDto save(ArticleDto articleDto) {
		
		
		List<String>errors = ArticleValidator.validate(articleDto);
		
		if(!errors.isEmpty()) {
			
			log.error("Article n'est pas valide", articleDto);
			throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
			
		}
		
		
		return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
		
		
	}

	@Override
	public ArticleDto findById(Integer id) {
		
		if(id == null ) {
			
			log.error("L'id de l'article est null");
			
			return null;
		}
		
		Optional<Article>article = articleRepository.findById(id);
		
		
		return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(
				() -> new EntityNotFoundException("L'id" + id + "n'existe pas", ErrorCodes.ARTICLE_NOT_FOUND) );
	}

	
	
	
	
	
	
	
	
	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
	
		if(!StringUtils.hasLength(codeArticle)) {
			
			log.error("Le code de l'article est null");
			
			return null;
		}
		
	Optional<Article>article = articleRepository.findByCodeArticle(codeArticle);
		
		
		return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(
				() -> new EntityNotFoundException("Le code " + codeArticle + "n'existe pas", ErrorCodes.ARTICLE_NOT_FOUND) );
	
	}

	@Override
	public List<ArticleDto> findAll() {
	
		return articleRepository.findAll().stream()
				.map(ArticleDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		
		if(id == null) {
			
			log.error("L'id de l'article est null");
			return;
			
		}
		
		articleRepository.deleteById(id);
	}

}
