package com.sogeti.library.dao;

import java.util.List;

import com.sogeti.library.models.Book;


public interface IBookDao {
	
	// find all books
	public List<Book> findAll();
	
	// find a book by id
	public Book findByIdBook(Long id);
	
	// add a book
	public String addBook(Book book);
	
	// update a book
	public String updateBook(Book book);
	
	// delete a book
	public String deleteBook(Book book);

}
