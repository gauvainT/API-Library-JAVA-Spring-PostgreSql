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

import com.sogeti.library.dao.ICategoryDao;
import com.sogeti.library.dao.rowMapper.CategoryRowMapper;
import com.sogeti.library.models.Category;

@Repository
public class CategoryDao implements ICategoryDao {
	
	public CategoryDao(NamedParameterJdbcTemplate jdbcTemplate) {  
        this.jdbcTemplate = jdbcTemplate;  
	}
	
	NamedParameterJdbcTemplate jdbcTemplate;  

	@Override
	public List<Category> findAll() {
		final String request = "SELECT * FROM category";
		try {
			return jdbcTemplate.query(request, new CategoryRowMapper());
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}

	@Override
	public Category findByIdCategory(Long id) {
		final String request = "SELECT * FROM category WHERE id_category = :idCategory";
		SqlParameterSource param = new MapSqlParameterSource()
		.addValue("idCategory", id);
		try {
	        return jdbcTemplate.queryForObject( request, param, new CategoryRowMapper());
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}

	@Override
	public String addCategory(Category category) {
		final String request = "INSERT INTO category (name_category) VALUES (:nameCategory)";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nameCategory", category.getNameCategory());
		
		try {
			jdbcTemplate.execute(request, map, new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        	ps.executeUpdate();  
				        return "success";
			    }
			});
			
		} catch (Exception e) {
			return e.getMessage().toString();
		}
		return "success";	
	}

	@Override
	public String updateCategory(Category category) {
		final String request = "UPDATE category SET name_category=:categoryName WHERE id_category=:idCategory";

		 Map<String,Object> map=new HashMap<String,Object>();  
		map.put("categoryName", category.getNameCategory());
		map.put("idCategory", category.getIdCategory());
		
		try {
			jdbcTemplate.execute(request, map, new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			         	ps.executeUpdate();  
				        return "success";
			    }
			});
			
		} catch (Exception e) {
			return e.getMessage().toString();
		}
		return "success";		
	}

	@Override
	public String deleteCategory(Category category) {
		 final String request = "DELETE FROM category WHERE id_category=:idCategory";
			
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("idCategory", category.getIdCategory());
			
		 try {
				jdbcTemplate.execute(request, map, new PreparedStatementCallback<Object>() {  
				    @Override  
				    public Object doInPreparedStatement(PreparedStatement ps)  
				            throws SQLException, DataAccessException {  
				        	ps.executeUpdate();
					        return "success";
				    }
				});
			
		} catch (Exception e) {
			return e.getMessage().toString();
		}
		 return "success";		
	}

}
