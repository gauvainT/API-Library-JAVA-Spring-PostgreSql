package com.sogeti.library.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sogeti.library.dao.impl.BookDao;
import com.sogeti.library.models.Book;
import com.sogeti.library.services.IBookService;

@Component
public class BookService implements IBookService {
	
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
	public String addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Transactional
	public String updateBook(Book book) {
		return bookDao.updateBook(book);
	}

	@Transactional
	public String deleteBook(Book book) {
		return bookDao.deleteBook(book);	
	}

}
