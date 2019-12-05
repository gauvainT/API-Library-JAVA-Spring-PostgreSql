package com.sogeti.library.dao;

import java.util.List;

import com.sogeti.library.models.Author;

public interface IAuthorDao {
	
	// find all authors
	public List<Author> findAll();
	
	// find an author by id
	public Author findByIdAuthor(Long id);
	
	// add an author
	public String addAuthor(Author author);
	
	// update an author
	public String updateAuthor(Author author);
	
	// delete an author
	public String deleteAuthor(Author author);

}
