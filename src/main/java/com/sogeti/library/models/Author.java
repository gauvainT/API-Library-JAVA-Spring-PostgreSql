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
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "firstname")
	private String firstname;

	// Constructeur
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(String name, String firstname) {
		super();
		this.name = name;
		this.firstname = firstname;
	}

	//Getter Setter
	
	public Long getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	// To string
	
	@Override
	public String toString() {
		return "Author [name=" + name + ", firstname=" + firstname + "]";
	}
	
	
	
}
