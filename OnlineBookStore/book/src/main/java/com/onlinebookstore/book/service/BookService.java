package com.onlinebookstore.book.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.onlinebookstore.book.bookpojo.BookPojo;
import com.onlinebookstore.book.bookpojo.BookPojoReview;

import jakarta.servlet.http.HttpServletRequest;

public interface BookService {
	
	BookPojo getBookById(Long bookId, HttpServletRequest request);

	List<BookPojo> getAllBooks(HttpServletRequest request);

	BookPojo addBook(BookPojo pojo);

	//List<BookPojo> getBooksByUsers(Long userId);

	BookPojoReview getBookByIdWithReview(Long bookId);

	

	void addBookDataWithFile(BookPojo bookPojo, MultipartFile imageFile);


	byte[] getBookImageById(Long bookId,HttpServletRequest request);

	List<BookPojo> getBookByAuthor(String author, HttpServletRequest request);

	List<BookPojo> getBookByTitle(String title, HttpServletRequest request);

	List<BookPojo> getBookBy(String description, HttpServletRequest request);



}
