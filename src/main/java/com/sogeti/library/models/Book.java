package com.sogeti.library.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBook", columnDefinition = "serial")
	private Long idBook;
	
	
	@Column(name="title")
	private String title;
	
	@Column(name="summary")
	private String summary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_author")
	private Author author;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private Category category;
	
	// Constructeur
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Long idBook, String title, String summary) {
		super();
		this.idBook = idBook;
		this.title = title;
		this.summary = summary;
	}

	public Book(String title, String summary, Author author, Category category) {
		super();
		this.title = title;
		this.summary = summary;
		this.author = author;
		this.category = category;
	}
	
	// Getter Setter
	
	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	// To string
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", summary=" + summary + ", author=" + author + ", category=" + category + "]";
	}
	
	
	
	

}
