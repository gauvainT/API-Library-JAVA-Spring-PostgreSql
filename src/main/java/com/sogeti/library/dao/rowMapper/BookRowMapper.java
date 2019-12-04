package com.sogeti.library.dao.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.sogeti.library.dao.impl.AuthorDao;
import com.sogeti.library.dao.impl.CategoryDao;
import com.sogeti.library.models.Author;
import com.sogeti.library.models.Book;
import com.sogeti.library.models.Category;


public class BookRowMapper implements RowMapper<Book> {
	
	@Autowired
	AuthorDao authorDao;
	
	@Autowired
	CategoryDao categoryDao;

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		/*
		Author author = null;

		if(rs.getString("id_author") != null) {
			Long idAuthor = Long.parseLong(rs.getString("id_author"));
			
			author = authorDao.findByIdAuthor(idAuthor);
		}
		
		Category category = null;
		
		if(rs.getString("id_category") != null) {
			
			Long idCategory = Long.parseLong(rs.getString("id_category"));
			
			category = categoryDao.findByIdCategory(idCategory);
		}
		*/
		Book book = new Book();
		book.setIdBook(rs.getLong("id_book"));
		book.setTitle(rs.getString("title"));
		book.setSummary(rs.getString("summary"));
		//book.setAuthor(author);
		//book.setCategory(category);

		return book;
	
	}

}
