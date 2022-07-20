package com.example.gestionStock.Services.Implements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.gestionStock.Dto.CommandeClientDto;
import com.example.gestionStock.Dto.LigneComClientDto;
import com.example.gestionStock.Entity.Article;
import com.example.gestionStock.Entity.Client;
import com.example.gestionStock.Entity.CommandeClient;
import com.example.gestionStock.Entity.LigneComClient;
import com.example.gestionStock.Exception.EntityNotFoundException;
import com.example.gestionStock.Exception.ErrorCodes;
import com.example.gestionStock.Exception.InvalidEntityException;
import com.example.gestionStock.Repository.ArticleRepository;
import com.example.gestionStock.Repository.ClientRepository;
import com.example.gestionStock.Repository.CommandeClientRepository;
import com.example.gestionStock.Repository.LigneCommandeClientRepository;
import com.example.gestionStock.Services.CommandeClientServiceInterface;
import com.example.gestionStock.Validators.CommandeClientValidator;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class CommandeClientServiceImp implements CommandeClientServiceInterface{

	
	private CommandeClientRepository commandeClientRepository;
	
	private ClientRepository clientRepository;
	
	private ArticleRepository articleRepository;
	
	private LigneCommandeClientRepository ligneCommandeClientRepository;
	
	
	
	@Autowired
	public CommandeClientServiceImp(CommandeClientRepository commandeClientRepository,
			ClientRepository clientRepository, ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepository) {
		
		this.commandeClientRepository = commandeClientRepository;
		this.clientRepository = clientRepository;
		this.articleRepository = articleRepository;
		this.ligneCommandeClientRepository = ligneCommandeClientRepository;
	}

	
	
	
	@Override
	public CommandeClientDto save(CommandeClientDto commandeClientDto) {
		
		
		List<String>errors = CommandeClientValidator.validate(commandeClientDto);
		
		if(!errors.isEmpty()) {
			
			log.error("Commande client non valide");
			throw new InvalidEntityException("Commande client non valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
			
		}
		
		Optional<Client>client = clientRepository.findById(commandeClientDto.getClient().getId());
		
		if(!client.isPresent()) {
			
			log.warn("Client n'existe pas", commandeClientDto.getClient().getId());
			
			throw new EntityNotFoundException("L'id de client" + commandeClientDto.getClient().getId() + "n'existe pas", ErrorCodes.CLIENT_NOT_FOUND);
		}
		
		List<String>articleErrors = new ArrayList<>();
		
		if(commandeClientDto.getLigneCommandeClient() != null) {
			
			commandeClientDto.getLigneCommandeClient().forEach(ligneCmdClt->{
				
				
				if(ligneCmdClt.getArticle() != null) {
				
				Optional<Article>article = articleRepository.findById(ligneCmdClt.getArticle().getId());
				
				if(article.isEmpty()) {
					
					articleErrors.add("L'id de l'article" + ligneCmdClt.getArticle().getId() + "n'existe pas");
					
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
		
		CommandeClient saveCmdClt = commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto));
		
		
		if(commandeClientDto.getLigneCommandeClient() != null) {
			
			
			commandeClientDto.getLigneCommandeClient().forEach(ligneCmdClt->{
				LigneComClient ligneCommandeClient = LigneComClientDto.toEntity(ligneCmdClt);
				
				ligneCommandeClient.setCommandeClient(saveCmdClt);
				
				ligneCommandeClientRepository.save(ligneCommandeClient);
			});
		}
		
		return CommandeClientDto.fromEntity(saveCmdClt);
	}

	
	
	
	@Override
	public CommandeClientDto findById(Integer id) {
		if(id == null) {
			return null;
		}
		return commandeClientRepository.findById(id)
				.map(CommandeClientDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException(
						"Acune commande client n'a été trouvé avec l'id " + id, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public CommandeClientDto findByCode(String code) {
		
		if(!StringUtils.hasLength(code)) {
			
			log.error("Code de commande de client est null");
			return null;
		}
		
		
		return commandeClientRepository.findCommandeClientByCodes(code)
				.map(CommandeClientDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException(
						"Acune commande client n'a été trouvé avec le code " + code, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public List<CommandeClientDto> findAll() {
		
		return commandeClientRepository.findAll().stream()
				.map(CommandeClientDto::fromEntity)
				.collect(Collectors.toList());
		
		
	}

	@Override
	public void delete(Integer id) {
		
		if(id == null) {
			
			log.error("Id de commande Client est null");
			return;
		}
		
		commandeClientRepository.deleteById(id);
		
	}

}
