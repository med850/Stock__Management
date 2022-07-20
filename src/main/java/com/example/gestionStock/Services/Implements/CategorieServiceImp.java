package com.example.gestionStock.Services.Implements;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.gestionStock.Dto.CategorieDto;
import com.example.gestionStock.Exception.EntityNotFoundException;
import com.example.gestionStock.Exception.ErrorCodes;
import com.example.gestionStock.Exception.InvalidEntityException;
import com.example.gestionStock.Repository.CategorieRepository;
import com.example.gestionStock.Services.CategorieServiceInterface;
import com.example.gestionStock.Validators.CategorieValidator;

import lombok.extern.slf4j.Slf4j;




@Service
@Slf4j
public class CategorieServiceImp implements CategorieServiceInterface{

	
	
	private CategorieRepository categorieRepository;
	
	
	@Autowired
	public CategorieServiceImp(CategorieRepository categorieRepository) {
		
		this.categorieRepository = categorieRepository;
		
	}
	
	
	
	@Override
	public CategorieDto save(CategorieDto categorieDto) {
	
		List<String>errors = CategorieValidator.validate(categorieDto);
		
		if(!errors.isEmpty()) {
			
			log.error("Categorie non valide", categorieDto);
			throw new InvalidEntityException("La catégorie n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
		}
		
		
		return CategorieDto.fromEntity(categorieRepository.save(CategorieDto.toEntity(categorieDto)));
	}
	
	
	
	

	@Override
	public CategorieDto findById(Integer id) {
		
		if(id == null) {
			log.error("L'id de catégorie est null");
			return null;
		}
		return categorieRepository.findById(id)
				.map(CategorieDto::fromEntity)
				.orElseThrow(
						()->new EntityNotFoundException(
						"L'id " + id + "n'existe pas", ErrorCodes.CATEGORY_NOT_FOUND));
	}

	
	
	
	
	
	@Override
	public CategorieDto findByCode(String code) {
		if(StringUtils.hasLength(code)) {
			
			log.error("Code de catégorie est null");
			return null;
		}
		return categorieRepository.findCategorieByCode(code)
				.map(CategorieDto::fromEntity)
				.orElseThrow(
						()->new EntityNotFoundException(
								"Code de catégorie" + code + "n'existe pas", ErrorCodes.CATEGORY_NOT_FOUND));
	}

	
	
	
	@Override
	public List<CategorieDto> findAll() {
		
		return categorieRepository.findAll().stream()
				.map(CategorieDto::fromEntity)
				.collect(Collectors.toList());
	}

	
	
	
	@Override
	public void delete(Integer id) {
		if(id == null) {
			
			log.error("L'id de catégorie est null");
			return;
			
			
		}
		categorieRepository.deleteById(id);
	}

}
