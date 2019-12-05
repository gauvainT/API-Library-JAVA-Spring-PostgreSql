package com.sogeti.library.services;

import java.util.List;

import com.sogeti.library.models.Category;

public interface ICategoryService {
	
	public List<Category> findAll();

	public Category findByIdCategory(Long id);

	public String addCategory(Category category);

	public String updateCategory(Category category);

	public String deleteCategory(Category category);

}
