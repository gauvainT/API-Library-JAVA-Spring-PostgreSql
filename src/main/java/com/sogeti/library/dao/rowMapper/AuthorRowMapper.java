package com.sogeti.library.dao.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sogeti.library.models.Author;

public class AuthorRowMapper implements RowMapper<Author>{

	@Override
	public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
		Author author = new Author();
		author.setIdAuthor(rs.getLong("id_author"));
		author.setNameAuthor(rs.getString("name_author"));
		author.setFirstnameAuthor(rs.getString("firstname_author"));
		return author;
	}

}
