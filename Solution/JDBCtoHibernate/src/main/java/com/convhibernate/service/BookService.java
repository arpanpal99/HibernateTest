package com.convhibernate.service;

import com.convhibernate.entity.Book;

public interface BookService {

	public void persistObjectGraph(Book book);
	public Book retrieveObjectGraph(String isbn);
	
}
