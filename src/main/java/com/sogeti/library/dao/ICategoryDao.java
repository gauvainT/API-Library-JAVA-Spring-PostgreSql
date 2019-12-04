package com.sogeti.library.dao;

import java.util.List;

import com.sogeti.library.models.Category;

public interface ICategoryDao {
	
	// find all categories
	public List<Category> findAll();
	
	// find a category by id
	public Category findByIdCategory(Long id);
	
	// add a category
	public void addCategory(Category category);
	
	// update a category
	public void updateCategory(Category category);
	
	// delete a category
	public void deleteCategory(Category category);

}
