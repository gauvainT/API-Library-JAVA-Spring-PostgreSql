package com.sogeti.library.services;

import java.util.List;

import com.sogeti.library.models.Author;

public interface IAuthorService {
	
	public List<Author> findAll();

	public Author findByIdAuthor(Long id);

	public void addAuthor(Author author);

	public void updateAuthor(Author author);

	public void deleteAuthor(Author author);

}
