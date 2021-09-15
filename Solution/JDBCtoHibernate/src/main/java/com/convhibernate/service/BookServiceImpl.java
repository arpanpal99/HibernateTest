package com.convhibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.convhibernate.dao.BookDao;
import com.convhibernate.entity.Book;




@Service(value = "bookService")
@Transactional
public class BookServiceImpl implements BookService {
	BookDao bookDao;
	
	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	@MyLogging
	@Override
	public void persistObjectGraph(Book book) {
		bookDao.persistObjectGraph(book);
	}
	@MyLogging
	@Override
	public Book retrieveObjectGraph(String isbn) {
		return bookDao.retrieveObjectGraph(isbn);
	}

}
