package com.example.gestionStock.Controller.Api;

import static com.example.gestionStock.Utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.gestionStock.Dto.ArticleDto;
import com.example.gestionStock.Dto.CategorieDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(APP_ROOT + "/categories")
public interface CategorieApi {

	
	
	
	@PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Enregistrer une catégorie", notes="Cette méthode permet d'enregistrer ou modifier une catégorie", response=CategorieDto.class )
	@ApiResponses(value= {
		@ApiResponse(code=200, message="Catégorie (crée / modifier) avec succé"),
		@ApiResponse(code=400, message="Catégorie n'est pas valide")	
	})
	CategorieDto save(@RequestBody CategorieDto categorieDto);
	
	
	
	
	
	
	
	@GetMapping(value = APP_ROOT + "/categories/{idCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Recherche d'une catégorie par  son id", notes="Cette méthode permet de trouver une catégorie à travers de son id", response=CategorieDto.class )
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Catégorie a été trouvé"),
			@ApiResponse(code=404, message="Aucune catégorie trouvé")
		})
	CategorieDto findById(@PathVariable("idCategorie")Integer idCategorie);
	
	
	
	
	
	@GetMapping(value = APP_ROOT + "/categories/{codeCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Recherche d'une catégorie par son code ", notes="Cette méthode permet de trouver une catégorie à travers de son code", response=CategorieDto.class )
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Catégorie a été trouvée"),
			@ApiResponse(code=404, message="Aucune catégorie trouvé")
		})
	CategorieDto findByCode(@PathVariable("codeCategorie")String codeCategorie);
	
	
	
	
	
	@GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Renvoi la liste des catégories", notes="Cette méthode permet d'afficher la liste des catégories", responseContainer= "List<CategorieDto>" )
	@ApiResponses(value= {
			@ApiResponse(code=200, message="La liste des catégories / Liste vide"),
		})
	List<CategorieDto>findAll();
	
	
	
	
	
	
	
	

	@DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategorie}")
	@ApiOperation(value = "Supprimer une catégorie", notes="Cette méthode permet de supprimer des catégories a travers son id", response=CategorieDto.class )
	@ApiResponses(value= {
			@ApiResponse(code=200, message="La catégorie a été supprimer avec succée  "),
		})
	void delete(@PathVariable("idCategorie")Integer id);
	
	
	
	
}
