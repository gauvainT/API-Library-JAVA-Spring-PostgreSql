package com.sogeti.library.services;

import java.util.List;

import com.sogeti.library.models.Book;

public interface IBookService {
	
	public List<Book> findAll();

	public Book findByIdBook(Long id);

	public String addBook(Book book);

	public String updateBook(Book book);

	public String deleteBook(Book book);


}
