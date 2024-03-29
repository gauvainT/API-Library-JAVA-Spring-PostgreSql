package com.sogeti.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.library.models.Category;
import com.sogeti.library.services.impl.CategoryService;

@CrossOrigin( origins = {"http://localhost" } )
@RestController
@RequestMapping("apiCategory")
public class CatogoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	/*
    * Description : recherche et renvoie la liste de toutes les catégories 
    * @param : aucun
    */
	@GetMapping("/findAllCategories")
	public List<Category> findAll() {
		return categoryService.findAll();
	}
	
	/*
    * Description : recherche une catégorie par son id et la renvoie
    * @param : Long id
    */
	@GetMapping("/findOneCategory")
	public Category findByIdCategory(@RequestParam(name = "id") Long id) {
		return categoryService.findByIdCategory(id);
	}

	/*
    * Description : ajoute une catégorie
    * @param : Category ( String nameCategory )
    */
	@PostMapping("/addCategory")
	public String addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	
	/*
    * Description : modifie une catégorie d'après son id 
    * @param : Category ( Long IdCategory, String nameCategory )
    */
	@PutMapping("/updateCategory")
	public String updateCategory(@RequestBody Category category) {
		return categoryService.updateCategory(category);
	}

	/*
    * Description : Supprime une catégorie
    * @param : Auteur ( Long idCategory, String nameCategory)
    */
	@DeleteMapping("/deleteCategory")
	public String deleteCategory(@RequestBody Category category) {
		return categoryService.deleteCategory(category);
	}
	
	/*
    * Description : Supprime une catégorie d'après son id
    * @param :Long id
    */
	@DeleteMapping("/deleteCategoryById")
	public String deleteCategoryById(@RequestParam(name = "id") Long id) {
		try {
			Category category = categoryService.findByIdCategory(id);
			if( category != null) {
				categoryService.deleteCategory(category);
			}
		} catch (Exception e) {
			return e.getMessage().toString();
		}
		
	
		return "success";
	}

}
