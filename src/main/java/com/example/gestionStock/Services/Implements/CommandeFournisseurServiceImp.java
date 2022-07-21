package com.example.gestionStock.Services.Implements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.gestionStock.Dto.CommandeClientDto;
import com.example.gestionStock.Dto.CommandeFournisseurDto;
import com.example.gestionStock.Dto.LigneComClientDto;
import com.example.gestionStock.Dto.LigneComFournisseurDto;
import com.example.gestionStock.Entity.Article;
import com.example.gestionStock.Entity.Client;
import com.example.gestionStock.Entity.CommandeClient;
import com.example.gestionStock.Entity.CommandeFournisseur;
import com.example.gestionStock.Entity.Fournisseur;
import com.example.gestionStock.Entity.LigneComClient;
import com.example.gestionStock.Entity.LigneComFournisseur;
import com.example.gestionStock.Exception.EntityNotFoundException;
import com.example.gestionStock.Exception.ErrorCodes;
import com.example.gestionStock.Exception.InvalidEntityException;
import com.example.gestionStock.Repository.ArticleRepository;
import com.example.gestionStock.Repository.ClientRepository;
import com.example.gestionStock.Repository.CommandeClientRepository;
import com.example.gestionStock.Repository.CommandeFournisseurRepository;
import com.example.gestionStock.Repository.FournisseurRepository;
import com.example.gestionStock.Repository.LigneCommandeClientRepository;
import com.example.gestionStock.Repository.LigneCommandeFournisseurRepository;
import com.example.gestionStock.Services.CommandeFournisseurServiceInterface;
import com.example.gestionStock.Validators.CommandeClientValidator;
import com.example.gestionStock.Validators.CommandeFournisseurValidator;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CommandeFournisseurServiceImp implements CommandeFournisseurServiceInterface{

	
private CommandeFournisseurRepository commandeFournisseurRepository;
	
	private FournisseurRepository fournisseurRepository;
	
	private ArticleRepository articleRepository;
	
	private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
	
	
	
	@Autowired
	public CommandeFournisseurServiceImp(CommandeFournisseurRepository commandeFournisseurRepository,
			FournisseurRepository fournisseurRepository, ArticleRepository articleRepository, LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository) {
		
		this.commandeFournisseurRepository = commandeFournisseurRepository;
		this.fournisseurRepository = fournisseurRepository;
		this.articleRepository = articleRepository;
		this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
	}
	
	
	
	@Override
	public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
		
		
		List<String>errors = CommandeFournisseurValidator.validate(commandeFournisseurDto);
		
		if(!errors.isEmpty()) {
			
			log.error("Commande fournisseur non valide");
			throw new InvalidEntityException("Commande fournisseur non valide", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID, errors);
			
		}
		
		Optional<Fournisseur>fournisseur = fournisseurRepository.findById(commandeFournisseurDto.getFournisseur().getId());
		
		if(!fournisseur.isPresent()) {
			
			log.warn("Fournisseur n'existe pas", commandeFournisseurDto.getFournisseur().getId());
			
			throw new EntityNotFoundException("L'id de fournisseur" + commandeFournisseurDto.getFournisseur().getId() + "n'existe pas", ErrorCodes.FOURNISSEUR_NOT_FOUND);
		}
		
		List<String>articleErrors = new ArrayList<>();
		
		if(commandeFournisseurDto.getLigneCommandeFournisseur() != null) {
			
			commandeFournisseurDto.getLigneCommandeFournisseur().forEach(ligneCmdFrn->{
				
				
				if(ligneCmdFrn.getArticle() != null) {
				
				Optional<Article>article = articleRepository.findById(ligneCmdFrn.getArticle().getId());
				
				if(article.isEmpty()) {
					
					articleErrors.add("L'id de l'article" + ligneCmdFrn.getArticle().getId() + "n'existe pas");
					
				}else {
					
					articleErrors.add("Impossible d'enregistrer une commande avec un article null");
					
				}
				}
			});
			
			
		}
		
		if(!articleErrors.isEmpty()) {
			
			log.warn("");
			throw new InvalidEntityException("Article n'existe pas", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
		}
		
		CommandeFournisseur saveCmdFrn = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(commandeFournisseurDto));
		
		
		if(commandeFournisseurDto.getLigneCommandeFournisseur() != null) {
			
			
			commandeFournisseurDto.getLigneCommandeFournisseur().forEach(ligneCmdFrn->{
				LigneComFournisseur ligneCommandeFournisseur = LigneComFournisseurDto.toEntity(ligneCmdFrn);
				
				ligneCommandeFournisseur.setCommandeFournisseur(saveCmdFrn);
				
				ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
			});
		}
		
		return CommandeFournisseurDto.fromEntity(saveCmdFrn);
	}



	@Override
	public CommandeFournisseurDto findById(Integer id) {
		if(id == null) {
			return null;
		}
		return commandeFournisseurRepository.findById(id)
				.map(CommandeFournisseurDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException(
						"Acune commande fournisseur n'a été trouvé avec l'id " + id, ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
	}

	@Override
	public CommandeFournisseurDto findByCode(String codes) {
		
		if(!StringUtils.hasLength(codes)) {
			
			log.error("Code de commande de fournisseur est null");
			return null;
		}
		
		
		return commandeFournisseurRepository.findCommandeFournisseurByCodes(codes)
				.map(CommandeFournisseurDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException(
						"Acune commande fournisseur n'a été trouvé avec le code " + codes, ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
	}

	
	
	
	@Override
	public List<CommandeFournisseurDto> findAll() {
		return commandeFournisseurRepository.findAll().stream()
				.map(CommandeFournisseurDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
	if(id == null) {
			
			log.error("Id de commande fournisseur est null");
			return;
		}
		
		commandeFournisseurRepository.deleteById(id);
		
		
	}

}
