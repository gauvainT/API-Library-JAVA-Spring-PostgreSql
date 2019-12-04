package com.sogeti.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.library.models.Author;
import com.sogeti.library.services.impl.AuthorService;

@CrossOrigin( origins = {"http://localhost" } )
@RestController
@RequestMapping("apiAuthor")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	/*
    * Description : recherche et renvoie la liste de tous les auteurs 
    * @param : aucun
    */
	@GetMapping("/findAllAuthors")
	public List<Author> findAll() {
		return authorService.findAll();
	}
	
	/*
    * Description : recherche un auteur par son id et le renvoie
    * @param : Long id
    */
	@GetMapping("/findOneAuthor")
	public Author findByIdAuthor(@RequestParam(name = "id") Long id) {
		return authorService.findByIdAuthor(id);
	}
	
	/*
    * Description : ajoute un auteur
    * @param : Auteur ( String nameAuthor )
    */
	@PostMapping("/addAuthor")
	public void addAuthor(@RequestBody Author author) {
		authorService.addAuthor(author);
	}

	/*
    * Description : modifie un auteur d'après son id 
    * @param : Auteur ( Long idAuthor, String nameAuthor)
    */
	@PutMapping("/updateAuthor")
	public void updateAuthor(@RequestBody Author author) {
		authorService.updateAuthor(author);
	}

	/*
    * Description : Supprime un auteur
    * @param : Auteur ( Long idAuthor, String nameAuthor)
    */
	@DeleteMapping("/deleteAuthor")
	public void deleteAuthor(@RequestBody Author author) {
		authorService.deleteAuthor(author);
	}
	
	/*
    * Description : Supprime un auteur d'après son id
    * @param : Long id
    */
	@DeleteMapping("/deleteAuthorById")
	public void deleteAuthorById(@RequestParam(name = "id") Long id) {
		Author author = authorService.findByIdAuthor(id);
		
		if(author != null) {
			authorService.deleteAuthor(author);
		}
	}

}
