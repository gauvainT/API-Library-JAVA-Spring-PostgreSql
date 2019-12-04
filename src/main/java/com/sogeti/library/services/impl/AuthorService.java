package com.sogeti.library.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sogeti.library.dao.impl.AuthorDao;
import com.sogeti.library.models.Author;

@Component
public class AuthorService {
	
	@Autowired
	private AuthorDao authorDao;
	
	@Transactional
	public List<Author> findAll() {
		return authorDao.findAll();
	}

	@Transactional
	public Author findByIdAuthor(Long id) {
		return authorDao.findByIdAuthor(id);
	}

	@Transactional
	public void addAuthor(Author author) {
		authorDao.addAuthor(author);
	}

	@Transactional
	public void updateAuthor(Author author) {
		authorDao.updateAuthor(author);
	}

	@Transactional
	public void deleteAuthor(Author author) {
		authorDao.deleteAuthor(author);
	}

}
