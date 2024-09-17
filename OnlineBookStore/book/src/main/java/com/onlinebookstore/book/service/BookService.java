package com.onlinebookstore.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinebookstore.book.dao.BookRepo;
import com.onlinebookstore.book.helper.ManualException;
import com.onlinebookstore.book.model.BookModel;

@Service
public class BookService {

	private final BookRepo repo;

	public BookService(BookRepo repo) {
		super();
		this.repo = repo;
	}

	public BookModel getBookById(Long bookId) {
		return repo.findById(bookId).orElseThrow(() -> new ManualException("Book Not Found"));
	}

	public List<BookModel> getAllBooks() {
		return repo.findAll();
	}

	public BookModel addBook(BookModel model) {
		return repo.save(model);
	}

	public List<BookModel> getBooksByUsers(Long userId) {
		return repo.findByUserId(userId);		
	}

}
