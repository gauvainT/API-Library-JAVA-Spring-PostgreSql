package com.sogeti.library.services;

import java.util.List;

import com.sogeti.library.models.Category;

public interface ICategoryService {
	
	public List<Category> findAll();

	public Category findByIdCategory(Long id);

	public void addCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(Category category);

}
