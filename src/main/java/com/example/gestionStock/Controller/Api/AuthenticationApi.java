package com.example.gestionStock.Controller.Api;

import static com.example.gestionStock.Utils.Constants.APP_ROOT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionStock.Dto.auth.AuthenticationResponse;
import com.example.gestionStock.Entity.auth.ExtendedUser;
import com.example.gestionStock.Services.auth.ApplicationUserDetailsService;
import com.example.gestionStock.Utils.JwtUtil;
import com.example.gestionStock.Dto.auth.AuthenticationRequest;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(APP_ROOT + "/auth")
public class AuthenticationApi {

	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private ApplicationUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest request){
		
		
		
			authManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getLogin(),
						request.getPassword()
						)
				);
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
		
		final String jwt = jwtUtil.generateToken((ExtendedUser)userDetails);		
		
		return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
		
		
	}
	
	
	
	
}
