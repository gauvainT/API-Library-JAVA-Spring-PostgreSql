package com.sogeti.library.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idCategory", columnDefinition = "serial")
	private Long idCategory;
	
	@Column(name = "name_category")
	private String nameCategory;

	// Constructeur
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Category(Long idCategory, String nameCategory) {
		super();
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
	}
	
	public Category(String nameCategory) {
		super();
		this.nameCategory = nameCategory;
	}

	// Getter Setter
	
	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
	// To string
	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", nameCategory=" + nameCategory + "]";
	}	

}
