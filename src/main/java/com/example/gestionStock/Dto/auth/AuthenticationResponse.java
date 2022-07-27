package com.example.gestionStock.Dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {

	
	private String accessToken;
	
	
}
