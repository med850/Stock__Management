package com.example.gestionStock.Dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.example.gestionStock.Entity.TypeMvtStock;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class MvtStockDto {

	
	private Integer id;

	
	private Instant dateMvt;
	
	
	private BigDecimal quantite;
	
	
	

	private ArticleDto article;
	
	
	private TypeMvtStock typeMvt;
	
	
}
