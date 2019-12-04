package com.sogeti.library.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idAuthor", columnDefinition = "serial")
	private Long idAuthor;
	
	@Column(name = "name_author")
	private String nameAuthor;
	
	@Column(name = "firstname_author")
	private String firstnameAuthor;

	// Constructeur
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Author(String nameAuthor, String firstnameAuthor) {
		super();
		this.nameAuthor = nameAuthor;
		this.firstnameAuthor = firstnameAuthor;
	}

	public Author(Long idAuthor, String nameAuthor, String firstnameAuthor) {
		super();
		this.idAuthor = idAuthor;
		this.nameAuthor = nameAuthor;
		this.firstnameAuthor = firstnameAuthor;
	}

	//Getter Setter
	
	public Long getIdAuthor() {
		return idAuthor;
	}


	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
	}


	public String getNameAuthor() {
		return nameAuthor;
	}


	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}


	public String getFirstnameAuthor() {
		return firstnameAuthor;
	}


	public void setFirstnameAuthor(String firstnameAuthor) {
		this.firstnameAuthor = firstnameAuthor;
	}

	// To string
	@Override
	public String toString() {
		return "Author [idAuthor=" + idAuthor + ", nameAuthor=" + nameAuthor + ", firstnameAuthor=" + firstnameAuthor + "]";
	}

	
}
