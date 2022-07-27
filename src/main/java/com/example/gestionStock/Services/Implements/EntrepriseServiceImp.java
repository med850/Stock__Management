package com.example.gestionStock.Services.Implements;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionStock.Dto.ClientDto;
import com.example.gestionStock.Dto.EntrepriseDto;
import com.example.gestionStock.Dto.UsersDto;
import com.example.gestionStock.Entity.Client;
import com.example.gestionStock.Entity.Entreprise;
import com.example.gestionStock.Exception.EntityNotFoundException;
import com.example.gestionStock.Exception.ErrorCodes;
import com.example.gestionStock.Repository.EntrepriseRepository;
import com.example.gestionStock.Services.EntrepriseServiceInterface;
import com.example.gestionStock.Validators.EntrepriseValidator;

import com.example.gestionStock.Exception.InvalidEntityException;


import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EntrepriseServiceImp implements EntrepriseServiceInterface{

	
	EntrepriseRepository entrepriseRepository;
	
	
	
	
	
	@Autowired
	public EntrepriseServiceImp(EntrepriseRepository entrepriseRepository) {
		this.entrepriseRepository = entrepriseRepository;
	}

	
	
	@Override
	public EntrepriseDto save(EntrepriseDto entrepriseDto) {

		List<String>errors = EntrepriseValidator.validate(entrepriseDto);
		
		if(!errors.isEmpty()) {
			
			log.error("Entreprise n'est pas valide", entrepriseDto);
			
			throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
		}
		
		
		return entrepriseDto.fromEntity(entrepriseRepository.save(entrepriseDto.toEntity(entrepriseDto)));
	}
	
	

	@Override
	public EntrepriseDto findById(Integer id) {
	
		if(id == null) {
			log.error("L'id de l'entreprise est null");
			return null;
		}
		
		//Optional<Entreprise>entreprise = entrepriseRepository.findById(id);
		
		
		Optional<Entreprise>entreprise = entrepriseRepository.findById(id);
		return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(
				()->new EntityNotFoundException("L'id" + id + "n'exsiste pas", ErrorCodes.ENTREPTRISE_NOT_FOUND)); 
	}

	@Override
	public List<EntrepriseDto> findAll() {
		
		return entrepriseRepository.findAll().stream()
				.map(EntrepriseDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		
if(id == null) {
			
			log.error("L'id de l'entreprise est null");
			return;
		}

	entrepriseRepository.deleteById(id);
		
	}
	
	
	
	/*private UsersDto fromEntreprise(EntrepriseDto dto) {
		
		return UsersDto.builder()
				.adresse(dto.getAdresse())
				.nom
		
		
	}*/
	
	
	private String generateRandomPassword() {
		
		return "som3R@nd0mP@$$word";
	}
	
	
	

}
