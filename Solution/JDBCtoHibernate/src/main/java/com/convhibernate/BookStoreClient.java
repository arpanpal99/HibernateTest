package com.convhibernate;

import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.convhibernate.config.AppConfig;
import com.convhibernate.entity.*;
import com.convhibernate.service.BookService;

public class BookStoreClient {

	public static void main(String[] args) {
		
		System.out.println("-------------------------------------------------");
		int count = 0;
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		BookService bookService=ctx.getBean("bookService",BookService.class);
		
		Book book = new Book("978-8131702215", "The Java Foundation" );
		Publisher publisher = new Publisher("A1001", "Computer Systems and Programming");
		book.setPublisherCode(publisher);
		
		List<Chapter> chap = new ArrayList<>();
		chap.add(new Chapter(new ChapterPK(book.getIsbn(), ++count), "Java Keywords"));
		chap.add(new Chapter(new ChapterPK(book.getIsbn(), ++count), "Object Oriented Programming"));
		chap.add(new Chapter(new ChapterPK(book.getIsbn(), ++count), "Java Collections"));
		chap.add(new Chapter(new ChapterPK(book.getIsbn(), ++count), "Java Exception Handling"));
		chap.add(new Chapter(new ChapterPK(book.getIsbn(), ++count), "Multi Threading"));
		book.setChapters(chap);
		
		bookService.persistObjectGraph(book);
		
		System.out.println("-------------------------------------------------");
		System.out.println("Successfully Retrieved Book with ISBN: " + book.getIsbn());
		System.out.println(bookService.retrieveObjectGraph("978-8131702215"));
		List<Chapter> chapters = bookService.retrieveObjectGraph("978-8131702215").getChapters();
		System.out.println("====================\n* List of chapters: ");
		chapters.stream().forEach(c -> System.out.println(c.getChapterPK().getChapterNumber() + ". " + c.getTitle()));
		System.out.println("-------------------------------------------------");
		
	}
	
}
