package com.sogeti.library.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sogeti.library.dao.impl.CategoryDao;
import com.sogeti.library.models.Category;
import com.sogeti.library.services.ICategoryService;

@Component
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Transactional
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Transactional
	public Category findByIdCategory(Long id) {
		return categoryDao.findByIdCategory(id);
	}

	@Transactional
	public String addCategory(Category category) {
		return categoryDao.addCategory(category);
	}

	@Transactional
	public String updateCategory(Category category) {
		return categoryDao.updateCategory(category);
	}

	@Transactional
	public String deleteCategory(Category category) {
		return categoryDao.deleteCategory(category);
	}

}
