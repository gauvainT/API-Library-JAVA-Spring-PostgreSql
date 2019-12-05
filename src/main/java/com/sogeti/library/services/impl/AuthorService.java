package com.sogeti.library.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sogeti.library.dao.impl.AuthorDao;
import com.sogeti.library.models.Author;
import com.sogeti.library.services.IAuthorService;

@Component
public class AuthorService implements IAuthorService{
	
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
	public String addAuthor(Author author) {
		return authorDao.addAuthor(author);
	}

	@Transactional
	public String updateAuthor(Author author) {
		return authorDao.updateAuthor(author);
	}

	@Transactional
	public String deleteAuthor(Author author) {
		return authorDao.deleteAuthor(author);
	}

}
