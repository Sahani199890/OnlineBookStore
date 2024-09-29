package com.onlinebookstore.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.book.bookpojo.BookPojo;
import com.onlinebookstore.book.bookpojo.BookPojoReview;
import com.onlinebookstore.book.bookpojo.ReviewPojo;
import com.onlinebookstore.book.dao.BookRepo;
import com.onlinebookstore.book.feignclinet.ReviewInterface;
import com.onlinebookstore.book.helper.ManualException;
import com.onlinebookstore.book.model.BookModel;

@Service
public class BookService {

	@Autowired
	private  BookRepo repo;
	
	@Autowired
	ReviewInterface reviewInterface;

	public BookPojo getBookById(Long bookId) {
		// rating int (0-5)
		// review
		BookModel bookData = repo.findById(bookId).orElseThrow(() -> new ManualException("Book Not Found"));
		BookPojo bookPojo = new BookPojo();
		BeanUtils.copyProperties(bookData, bookPojo);
		return bookPojo;
	}

	public List<BookPojo> getAllBooks() {
		List<BookModel> bookList = repo.findAll();

		List<BookPojo> bookPojoList = new ArrayList<>();
		for (BookModel bookModel : bookList) {
			BookPojo bookPojo = new BookPojo();
			BeanUtils.copyProperties(bookModel, bookPojo);
			bookPojoList.add(bookPojo);

		}

		return bookPojoList;
	}

	public BookPojo addBook(BookPojo model) {

		BookModel bookModel = new BookModel();
		BeanUtils.copyProperties(model, bookModel);
		repo.save(bookModel);
		return model;

	}

	
	public BookPojoReview getBookByIdWithReview(Long bookId) {
		// TODO Auto-generated method stub
		
	BookModel book = repo.findById(bookId).get();
	BookPojo bookPojo = new BookPojo();
	BeanUtils.copyProperties(book, bookPojo);
	
	ReviewPojo reviewPojo = reviewInterface.reviewByBookId(bookId);
	BookPojoReview bookPojoReview=new BookPojoReview(bookPojo, reviewPojo);
		return bookPojoReview;
	}

//	public List<BookPojo> getBooksByUsers(Long userId) {
//	List<BookModel> book = repo.findByUserId(userId);
//	}

}
