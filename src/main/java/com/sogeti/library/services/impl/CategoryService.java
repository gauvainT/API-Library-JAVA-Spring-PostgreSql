package com.sogeti.library.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sogeti.library.dao.impl.CategoryDao;
import com.sogeti.library.models.Category;

@Component
public class CategoryService {
	
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
	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}

	@Transactional
	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}

	@Transactional
	public void deleteCategory(Category category) {
		categoryDao.deleteCategory(category);
	}

}
