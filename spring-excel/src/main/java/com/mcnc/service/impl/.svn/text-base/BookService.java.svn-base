package com.mcnc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mcnc.dto.Book;
import com.mcnc.service.api.IBookService;
@Service
public class BookService implements IBookService{

	@Override
	public List<Book> getBooks() {
		List<Book> books = new ArrayList<Book>();

		books.add(new Book("Effective Java", "Joshua Bloch", "0321356683", "May 28, 2008", 38.11F));
		books.add(new Book("Head First Java", "Kathy Sierra & Bert Bates", "0596009208", "February 9, 2005", 30.80F));
		books.add(new Book("Java Generics and Collections", "Philip Wadler", "0596527756", "Oct 24, 2006", 29.52F));
		books.add(new Book("Thinking in Java", "Bruce Eckel", "0596527756", "February 20, 2006", 43.97F));
		books.add(new Book("Spring in Action", "Craig Walls", "1935182358", "June 29, 2011", 31.98F));
		
		return books;
	}

}
