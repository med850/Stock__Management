package com.example.gestionStock.Dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.example.gestionStock.Entity.MvtStock;
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
	
	
	//private Integer idEntreprise;
	
	
	private TypeMvtStock typeMvt;
	
	
	public static MvtStockDto fromEntity(MvtStock mvtStock) {
		
		
		if(mvtStock == null) {
			
			return null;
		}
		
		return MvtStockDto.builder()
				.id(mvtStock.getId())
				.dateMvt(mvtStock.getDateMvt())
				.quantite(mvtStock.getQuantite())
				.article(ArticleDto.fromEntity(mvtStock.getArticle()))
				.typeMvt(mvtStock.getTypeMvt())
				.build();
		
		
	}
	
	
	public static MvtStock toEntity(MvtStockDto mvtStockDto) {
		
		if(mvtStockDto == null) {
			
			return null;
		}
		
		MvtStock mvtStock = new MvtStock();
		
		mvtStock.setId(mvtStockDto.getId());
		mvtStock.setDateMvt(mvtStockDto.getDateMvt());
		mvtStock.setQuantite(mvtStockDto.getQuantite());
		mvtStock.setArticle(ArticleDto.toEntity(mvtStockDto.getArticle()));
		mvtStock.setTypeMvt(mvtStockDto.getTypeMvt());
		
		return mvtStock;
		
		
	}
	
	
	
}
