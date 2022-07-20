package com.example.gestionStock.Services.Implements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.gestionStock.Dto.LigneVenteDto;
import com.example.gestionStock.Dto.VentesDto;
import com.example.gestionStock.Entity.Article;
import com.example.gestionStock.Entity.LigneVente;
import com.example.gestionStock.Entity.Ventes;
import com.example.gestionStock.Exception.EntityNotFoundException;
import com.example.gestionStock.Exception.ErrorCodes;
import com.example.gestionStock.Exception.InvalidEntityException;
import com.example.gestionStock.Repository.ArticleRepository;
import com.example.gestionStock.Repository.LigneVenteRepository;
import com.example.gestionStock.Repository.VentesRepository;
import com.example.gestionStock.Services.VenteServiceInterface;
import com.example.gestionStock.Validators.CommandeClientValidator;
import com.example.gestionStock.Validators.VentesValidator;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class VenteServiceImp implements VenteServiceInterface {

	
	private ArticleRepository articleRepository;
	
	private VentesRepository ventesRepository;
	
	private LigneVenteRepository ligneVenteRepository;
	
	
	
	@Autowired
	public VenteServiceImp(ArticleRepository articleRepository, VentesRepository ventesRepository,
			LigneVenteRepository ligneVenteRepository) {
		
		this.articleRepository = articleRepository;
		this.ventesRepository = ventesRepository;
		this.ligneVenteRepository = ligneVenteRepository;
	}

	@Override
	public VentesDto save(VentesDto venteDto) {
		
		List<String>errors = VentesValidator.validate(venteDto);
		

				
			if(!errors.isEmpty()) {
				
				log.error("Vente n'est pas valide");
				throw new InvalidEntityException("L'objet vente n'est pas valide", ErrorCodes.VENTE_NOT_VALID, errors);
			}
		
	
			List<String>articleErrors = new ArrayList<>();
			
			venteDto.getLigneVente().forEach(ligneVenteDto->{
				Optional<Article>article = articleRepository.findById(ligneVenteDto.getArticle().getId());
				
				
				if(article.isEmpty()) {
					
					articleErrors.add("L'article avec l'id" + ligneVenteDto.getArticle().getId() + "n'existe pas");
				}
			});
			
			
			if(!articleErrors.isEmpty()) {
				
			log.error("Un ou plusieurs article n'existe pas", errors);
			throw new InvalidEntityException("Un ou plusieurs article n'ont pas été trouvé dans la base de donnée", ErrorCodes.VENTE_NOT_VALID, errors);
				
				
			}
			
			Ventes savedVentes = ventesRepository.save(VentesDto.toEntity(venteDto));
			
			
			venteDto.getLigneVente().forEach(ligneVenteDto->{
				LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
				
				
				ligneVente.setVente(savedVentes);
				
				ligneVenteRepository.save(ligneVente);
			});
		
		return VentesDto.fromEntity(savedVentes);
	}

	
	
	
	
	
	@Override
	public VentesDto findById(Integer id) {
		if(id == null) {
			log.error("Id de vente est null");
			return null;
		}
		return ventesRepository.findById(id)
				.map(VentesDto::fromEntity)
				.orElseThrow(
						()-> new EntityNotFoundException("Aucun vente n'a été trouvé", ErrorCodes.VENTE_NOT_FOUND));
	}

	@Override
	public VentesDto findByCode(String code) {
		if(!StringUtils.hasLength(code)) {
			
			log.error("Code de vente est null");
			return null;
			
		}
		return ventesRepository.findVentesByCode(code)
				.map(VentesDto::fromEntity)
				.orElseThrow(
						()->new EntityNotFoundException("Aucune vente client existe avec le code" + code, ErrorCodes.VENTE_NOT_FOUND));
	}

	@Override
	public List<VentesDto> findAll() {
		
	
		return ventesRepository.findAll().stream()
				.map(VentesDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			
			log.error("L'id de vente est null");
			return ;
		}
		
		ventesRepository.deleteById(id);
		
	}

}
