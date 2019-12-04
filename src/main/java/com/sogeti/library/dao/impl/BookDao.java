package com.sogeti.library.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.sogeti.library.dao.IBookDao;
import com.sogeti.library.dao.rowMapper.BookRowMapper;
import com.sogeti.library.models.Book;


@Repository
public class BookDao implements IBookDao {
	
	public BookDao(NamedParameterJdbcTemplate jdbcTemplate) {  
        this.jdbcTemplate = jdbcTemplate;  
	}
	
	NamedParameterJdbcTemplate jdbcTemplate;  

	@Override
	public List<Book> findAll() {
		final String request = "SELECT * FROM book INNER JOIN author ON (book.id_author = author.id_author) INNER JOIN category ON (book.id_category = category.id_category)";
 
		try {
			return jdbcTemplate.query(request, new BookRowMapper());
		}
		catch (Exception e) {
			e.getMessage().toString();
			return null;
		}
	}

	@Override
	public Book findByIdBook(Long id) {
		
		final String request = "SELECT * FROM book INNER JOIN author ON (book.id_author = author.id_author) INNER JOIN category ON (book.id_category = category.id_category) WHERE id_book = :idBook";
		
		SqlParameterSource param = new MapSqlParameterSource()
		.addValue("idBook", id);
		
		try {
			return jdbcTemplate.queryForObject( request, param, new BookRowMapper());
		}
		catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}

	@Override
	public void addBook(Book book) {
		
		final String request = "INSERT INTO book (title, summary, id_author, id_category) VALUES (:titleBook, :summaryBook, :idAuthor, :idCategory )";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("titleBook", book.getTitle());
		map.put("summaryBook", book.getSummary());
		map.put("idAuthor", book.getAuthor().getIdAuthor());
		map.put("idCategory", book.getCategory().getIdCategory());
		try {
			jdbcTemplate.execute(request, map, new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }
			});
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}

	@Override
	public void updateBook(Book book) {
		final String request = "UPDATE book SET title=:titleBook, summary=:summaryBook, id_author=:idAuthor, id_category=:idCategory WHERE id_book=:idBook";

		 Map<String,Object> map=new HashMap<String,Object>();  
		map.put("titleBook", book.getTitle());
		map.put("summaryBook", book.getSummary());
		map.put("idBook", book.getIdBook());
		map.put("idAuthor", book.getAuthor().getIdAuthor());
		map.put("idCategory", book.getCategory().getIdCategory());
		
		try {
			jdbcTemplate.execute(request, map, new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }
			});
		}catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}	
	}
		
	@Override
	public void deleteBook(Book book) {
		 final String request = "DELETE FROM book WHERE id_book=:idBook";
			
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("idBook", book.getIdBook());
		try {
			jdbcTemplate.execute(request, map, new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }
			});
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}

}
