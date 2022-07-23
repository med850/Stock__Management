package com.example.gestionStock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionStock.Controller.Api.ClientApi;
import com.example.gestionStock.Dto.ClientDto;
import com.example.gestionStock.Services.ClientServiceInterface;


@RestController
public class ClientsController implements ClientApi{

	
	private ClientServiceInterface clientService;
	
	
	
	
	
	@Autowired
	public ClientsController(ClientServiceInterface clientService) {
		
		this.clientService = clientService;
	}

	@Override
	public ClientDto save(ClientDto clientDto) {
		
		return clientService.save(clientDto);
	}

	@Override
	public ClientDto findById(Integer id) {
	
		return clientService.findById(id);
	}

	@Override
	public List<ClientDto> findAll() {
		
		return clientService.findAll();
	}

	@Override
	public void delete(Integer id) {
		clientService.delete(id);
		
	}

}
