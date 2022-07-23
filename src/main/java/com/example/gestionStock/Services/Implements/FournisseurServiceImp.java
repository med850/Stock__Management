package com.example.gestionStock.Services.Implements;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.gestionStock.Dto.ClientDto;
import com.example.gestionStock.Dto.FournisseurDto;
import com.example.gestionStock.Entity.Client;
import com.example.gestionStock.Entity.Fournisseur;
import com.example.gestionStock.Exception.EntityNotFoundException;
import com.example.gestionStock.Exception.ErrorCodes;
import com.example.gestionStock.Exception.InvalidEntityException;
import com.example.gestionStock.Repository.FournisseurRepository;
import com.example.gestionStock.Services.FournisseurServiceInterface;
import com.example.gestionStock.Validators.ClientValidator;
import com.example.gestionStock.Validators.FournisseurValidator;

public class FournisseurServiceImp implements FournisseurServiceInterface{

	
	
	FournisseurRepository fournisseurRepository;
	
	
	
	
	
	@Autowired
	public FournisseurServiceImp(FournisseurRepository fournisseurRepository) {
		this.fournisseurRepository = fournisseurRepository;
	}

	@Override
	public FournisseurDto save(FournisseurDto fournisseurDto) {
		
	List<String>errors = FournisseurValidator.validate(fournisseurDto);
		
		if(!errors.isEmpty()) {
			
			
			//log.error("Client n'est pas valide", fournisseurDto);
			
			throw new InvalidEntityException("Le fournisseur n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);

		}
		
		return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEntity(fournisseurDto)));
	}

	@Override
	public FournisseurDto findById(Integer id) {
		
if(id == null) {
			
		//	log.error("L'id de client est null");
			return null;
		}
		
		Optional<Fournisseur>fournisseur = fournisseurRepository.findById(id);
		return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(
				()-> new EntityNotFoundException("L'id" + id + "n'existe pas", ErrorCodes.FOURNISSEUR_NOT_FOUND));
	}

	@Override
	public List<FournisseurDto> findAll() {
		
		return fournisseurRepository.findAll().stream()
				.map(FournisseurDto::fromEntity)
				.collect(Collectors.toList());
	}
	

	@Override
	public void delete(Integer id) {
		

if(id == null) {
			
		//	log.error("L'id de client est null");
			return;
		}
		
		fournisseurRepository.deleteById(id);
	
		
	}

}
