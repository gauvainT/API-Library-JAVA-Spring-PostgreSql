package com.sogeti.library.services;

import java.util.List;

import com.sogeti.library.models.Book;

public interface IBookService {
	
	public List<Book> findAll();

	public Book findByIdBook(Long id);

	public void addBook(Book book);

	public void updateBook(Book book);

	public void deleteBook(Book book);


}
