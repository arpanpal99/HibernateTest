package com.convhibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.convhibernate.entity.Book;
import com.convhibernate.entity.Chapter;
import com.convhibernate.entity.Publisher;

@Repository
public class BookDaoImpl implements BookDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public BookDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void persistObjectGraph(Book book) {
		List<Chapter> chapter = book.getChapters();
		Publisher publisherCode = book.getPublisherCode();
		getSession().save(book);
		getSession().save(publisherCode);
		for(Chapter c: chapter)
		getSession().save(c);
		
	}

	@Override
	public Book retrieveObjectGraph(String isbn) {
		Book book=getSession().get(Book.class,isbn);
		return book;
	}
	
}
