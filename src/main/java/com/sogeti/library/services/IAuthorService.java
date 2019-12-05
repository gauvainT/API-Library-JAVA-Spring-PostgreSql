package com.sogeti.library.services;

import java.util.List;

import com.sogeti.library.models.Author;

public interface IAuthorService {
	
	public List<Author> findAll();

	public Author findByIdAuthor(Long id);

	public String addAuthor(Author author);

	public String updateAuthor(Author author);

	public String deleteAuthor(Author author);

}
