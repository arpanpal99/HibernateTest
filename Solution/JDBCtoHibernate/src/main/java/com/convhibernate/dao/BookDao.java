package com.convhibernate.dao;

import com.convhibernate.entity.Book;

public interface BookDao {

	public void persistObjectGraph(Book book);
	public Book retrieveObjectGraph(String isbn);
	
}
