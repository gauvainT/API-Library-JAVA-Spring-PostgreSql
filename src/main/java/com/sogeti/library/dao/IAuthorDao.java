package com.sogeti.library.dao;

import java.util.List;

import com.sogeti.library.models.Author;

public interface IAuthorDao {
	
	// find all authors
	public List<Author> findAll();
	
	// find an author by id
	public Author findByIdAuthor(Long id);
	
	// add an author
	public void addAuthor(Author author);
	
	// update an author
	public void updateAuthor(Author author);
	
	// delete an author
	public void deleteAuthor(Author author);

}
