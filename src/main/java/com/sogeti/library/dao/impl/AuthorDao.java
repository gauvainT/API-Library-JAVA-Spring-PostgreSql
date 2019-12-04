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

import com.sogeti.library.dao.IAuthorDao;
import com.sogeti.library.dao.rowMapper.AuthorRowMapper;
import com.sogeti.library.models.Author;


@Repository
public class AuthorDao implements IAuthorDao {
	

	public AuthorDao(NamedParameterJdbcTemplate jdbcTemplate) {  
	        this.jdbcTemplate = jdbcTemplate;  
	}
	
	NamedParameterJdbcTemplate jdbcTemplate;  

	@Override
	public List<Author> findAll(){
		final String request = "SELECT * FROM author";
		try {
			return jdbcTemplate.query(request, new AuthorRowMapper());
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}
	
	@Override
	public Author findByIdAuthor(Long id) {
		final String request = "SELECT * FROM author WHERE id_author = :idAuthor";
		SqlParameterSource param = new MapSqlParameterSource()
		.addValue("idAuthor", id);
		try {
	        return jdbcTemplate.queryForObject( request, param, new AuthorRowMapper());
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}
	
	@Override
	public void addAuthor(Author author) {
		
		final String request = "INSERT INTO author (name_author, firstname_author) VALUES (:nameAuthor, :firstnameAuthor)";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nameAuthor", author.getNameAuthor());
		map.put("firstnameAuthor", author.getFirstnameAuthor());
		
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
	public void updateAuthor(Author author) {
		final String request = "UPDATE author SET name_author=:authorName, firstname_author=:authorFirstname WHERE id_author=:idAuthor";

		 Map<String,Object> map=new HashMap<String,Object>();  
		map.put("authorName", author.getNameAuthor());
		map.put("authorFirstname", author.getFirstnameAuthor());
		map.put("idAuthor", author.getIdAuthor());
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
	public void deleteAuthor(Author author) {
		 final String request = "DELETE FROM author WHERE id_author=:idAuthor";
	
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("idAuthor", author.getIdAuthor());
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
