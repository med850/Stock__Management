package com.example.gestionStock.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.gestionStock.Services.auth.ApplicationUserDetailsService;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private ApplicationUserDetailsService appUserDetailService;
	
	@Autowired
	private ApplicationRequestFilter appRequestFilter;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(appUserDetailService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeRequests().antMatchers("/**/authenticate",
				"/**/entreprise/create",
				"/v2/api-docs",
				"/swagger-resources",
				"/swagger-resources/**",
				"/configuration/ui",
				"/configuration/security",
				"/swagger-ui.html",
				"/webjars/**",
				"v3/api-docs/**",
				"/swagger-ui/**").permitAll()
		.anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(appRequestFilter,UsernamePasswordAuthenticationFilter.class);
	}

	
	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {

		
		return authenticationManagerBean();
	}
	
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	

	
	
	
	
	
}
