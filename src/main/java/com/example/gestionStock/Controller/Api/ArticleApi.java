package com.example.gestionStock.Controller.Api;


import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.gestionStock.Dto.ArticleDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import static com.example.gestionStock.Utils.Constants.APP_ROOT;



@Api(APP_ROOT + "/articles")
public interface ArticleApi {

	
	
	@PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Enregistrer un article", notes="Cette méthode permet d'enregistrer ou modifier un article", response=ArticleDto.class )
	@ApiResponses(value= {
		@ApiResponse(code=200, message="Article (crée / modifier) avec succé"),
		@ApiResponse(code=400, message="Article n'est pas valide")	
	})
	ArticleDto save(@RequestBody ArticleDto articleDto);
	
	
	
	
	
	
	@GetMapping(value = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Recherche d'un article par id", notes="Cette méthode permet de trouver un article à travers de son id", response=ArticleDto.class )
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Article a été trouvé"),
			@ApiResponse(code=404, message="Aucun article trouvé")
		})
	ArticleDto findById(@PathVariable("idArticle") Integer id);
	
	
	
	
	
	
	@GetMapping(value = APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Recherche d'un article par code de l'article", notes="Cette méthode permet de trouver un article à travers de son code", response=ArticleDto.class )
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Article a été trouvé"),
			@ApiResponse(code=404, message="Aucun article trouvé")
		})
	ArticleDto findByCodeArticle(@PathVariable("codeArticle")String codeArticle);
	
	
	
	
	
	
	
	
	
	@GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Renvoi la liste des articles", notes="Cette méthode permet d'afficher la liste des articles", responseContainer= "List<ArticleDto>" )
	@ApiResponses(value= {
			@ApiResponse(code=200, message="La liste des articles / Liste vide"),
		})
	List<ArticleDto> findAll();
	
	
	
	
	
	
	
	@DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")
	@ApiOperation(value = "Supprimer un article", notes="Cette méthode permet de supprimer des article a travers son id", response=ArticleDto.class )
	@ApiResponses(value= {
			@ApiResponse(code=200, message="L'article a été supprimer avec succé  "),
		})
	void delete(@PathVariable("idArticle")Integer id);
	
	
	
}
