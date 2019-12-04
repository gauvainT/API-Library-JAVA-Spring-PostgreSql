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
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.library.models.Book;
import com.sogeti.library.services.impl.BookService;

@CrossOrigin( origins = {"http://localhost" } )
@RestController
@RequestMapping("apiBook")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	/*
    * Description : recherche et renvoie la liste de tous les livres 
    * @param : aucun
    */
	@GetMapping("/findAllBooks")
	public List<Book> findAll() {
		return bookService.findAll();
	}
	
	/*
    * Description : recherche un livre par son id et le renvoie
    * @param : Long id
    */
	@GetMapping("/findOneBook")
	public Book findByIdBook(@RequestBody Long id) {
		return bookService.findByIdBook(id);
	}

	/*
    * Description : ajoute un livre
    * @param : Book ( String title, String summary, Author author, Category category )
    */
	@PostMapping("/addBook")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}

	/*
    * Description : modifie un livre d'après son id 
    * @param : Book ( Long IdBook, String title, String summary, Author author, Category category )
    */
	@PutMapping("/updateBook")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
	}

	/*
    * Description : Supprime un livre
    * @param : Auteur ( Long idBook, String title, String summary)
    */
	@DeleteMapping("/deleteBook")
	public void deleteBook(@RequestBody Book book) {
		bookService.deleteBook(book);	
	}
	
	/*
    * Description : Supprime un livre d'après son id
    * @param :Long id
    */
	@DeleteMapping("/deleteBookById")
	public void deleteBookById(@RequestBody Long id) {
		Book book = bookService.findByIdBook(id);
		
		if(book != null) {
			bookService.deleteBook(book);
		}
	}

}
