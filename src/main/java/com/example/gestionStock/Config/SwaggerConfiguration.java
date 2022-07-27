package com.example.gestionStock.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.example.gestionStock.Utils.Constants.APP_ROOT;

import java.util.Collections;
import java.util.List;


@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfiguration {

	
	public static final String AUTHORZATION_HEADER = "Authorization";
	
	
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(
						
				new ApiInfoBuilder()
				.description("Gestion de stock API documentation")
				.title("Gestion de stock REST API")
				.build())
				.groupName("REST API V1")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.gestionStock"))
				.paths(PathSelectors.ant(APP_ROOT + "/**"))
				.build();
				
	}
	
	
	
	private ApiKey apiKey() {
		
		return new ApiKey("JWT", AUTHORZATION_HEADER, "header");
		
	}
	
	private SecurityContext securityContext() {
		
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
		
	}
	
	
	
	List<SecurityReference>defaultAuth(){
		
		AuthorizationScope authScope = new AuthorizationScope("global", "accessEveryThing");
		
		AuthorizationScope[]authScopes = new AuthorizationScope[1];
		
		authScopes[0] = authScope;
		
		return Collections.singletonList(
				new SecurityReference("JWT", authScopes)); 
		
		
	}
	
}
