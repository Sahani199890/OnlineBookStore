package com.onlinebookstore.book.service;

import java.util.List;

import com.onlinebookstore.book.model.BookModel;

public interface BookServiceImp {
	BookModel getBookById(Long bookId);

	List<BookModel> getAllBooks();

	BookModel addBook(BookModel model);

	List<BookModel> getBooksByUsers(Long userId);

}
