package com.sogeti.library.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sogeti.library.dao.impl.BookDao;
import com.sogeti.library.models.Book;

@Component
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	@Transactional
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Transactional
	public Book findByIdBook(Long id) {
		return bookDao.findByIdBook(id);
	}

	@Transactional
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Transactional
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Transactional
	public void deleteBook(Book book) {
		bookDao.deleteBook(book);	
	}

}
