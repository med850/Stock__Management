package com.example.gestionStock.Dto;

import java.math.BigDecimal;

import com.example.gestionStock.Entity.Article;
import com.example.gestionStock.Entity.Categorie;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ArticleDto {

	
	private Integer id;

	private String codeArticle;
	

	private String designation;
	

	private BigDecimal prixUNitaireHt;
	

	private BigDecimal tva;
	

	private BigDecimal prixUNitaireLtc;
	
	

	private String photo;
	
	
	private CategorieDto categorie;
	
	
	
	public static ArticleDto fromEntity(Article article) {
		
		if(article == null ) {
			return null;
		}
		return ArticleDto.builder()
				.id(article.getId())
				.codeArticle(article.getCodeArticle())
				.designation(article.getDesignation())
				.photo(article.getPhoto())
				.prixUNitaireHt(article.getPrixUNitaireHt())
				.prixUNitaireLtc(article.getPrixUNitaireLtc())
				.tva(article.getTva())
				.categorie(CategorieDto.fromEntity(article.getCategorie()))
				.build();
		
		
	}
	
	
	
	public static Article toEntity(ArticleDto articleDto) {
		
		if(articleDto == null) {
			return null;
		}
		
		Article article = new Article();
		
		article.setId(articleDto.getId());
		article.setCodeArticle(articleDto.getCodeArticle());
		article.setDesignation(articleDto.getDesignation());
		article.setPhoto(articleDto.getPhoto());
		article.setPrixUNitaireHt(articleDto.getPrixUNitaireHt());
		article.setPrixUNitaireLtc(articleDto.getPrixUNitaireLtc());
		article.setTva(articleDto.getTva());
		//article.setCategorie(articleDto.getCategorie());
		
		return article;
	}
	
	
	
	
	
}
