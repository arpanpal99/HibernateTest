package com.convhibernate.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "book")
public class Book {
	@Id
	private String isbn;
	private String bookName;
	@ManyToOne(fetch = FetchType.EAGER)
	private Publisher publisherCode;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Chapter> chapters;
	
	public Book(String isbn, String name) {
		this.isbn = isbn;
		this.bookName = name;
	}

}












































