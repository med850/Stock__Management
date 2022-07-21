package com.example.gestionStock.Services.Implements;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionStock.Dto.ClientDto;
import com.example.gestionStock.Entity.Client;
import com.example.gestionStock.Exception.EntityNotFoundException;
import com.example.gestionStock.Exception.ErrorCodes;
import com.example.gestionStock.Exception.InvalidEntityException;
import com.example.gestionStock.Repository.ClientRepository;
import com.example.gestionStock.Services.ClientServiceInterface;
import com.example.gestionStock.Validators.ClientValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImp implements ClientServiceInterface{

	
	
	
	ClientRepository clientRepository;
	

	@Autowired
	public ClientServiceImp(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	
	
	@Override
	public ClientDto save(ClientDto clientDto) {
	
		List<String>errors = ClientValidator.validate(clientDto);
		
		if(!errors.isEmpty()) {
			
			log.error("Client n'est pas valide", clientDto);
			
			throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);

		}
		
		
		
		
		return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(clientDto)));
	}

	
	
	@Override
	public ClientDto findById(Integer id) {
		if(id == null) {
			
			log.error("L'id de client est null");
			return null;
		}
		
		Optional<Client>client = clientRepository.findById(id);
		return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(
				()-> new EntityNotFoundException("L'id" + id + "n'existe pas", ErrorCodes.CLIENT_NOT_FOUND));
	}

	@Override
	public List<ClientDto> findAll() {
		
				
		return clientRepository.findAll().stream()
				.map(ClientDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			
			log.error("L'id de client est null");
			return;
		}
		
		clientRepository.deleteById(id);
		
	}

}
