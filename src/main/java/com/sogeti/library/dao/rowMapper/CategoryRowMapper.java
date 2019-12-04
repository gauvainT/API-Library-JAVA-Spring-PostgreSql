package com.sogeti.library.dao.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sogeti.library.models.Category;

public class CategoryRowMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category = new Category();
		category.setIdCategory(rs.getLong("id_category"));
		category.setNameCategory(rs.getString("name_category"));
		return category;
	}

}
