package com.onlinebookstore.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.book.bookpojo.BookPojo;
import com.onlinebookstore.book.bookpojo.BookPojoReview;
import com.onlinebookstore.book.bookpojo.ReviewPojo;
import com.onlinebookstore.book.feignclinet.ReviewInterface;
import com.onlinebookstore.book.model.BookModel;
import com.onlinebookstore.book.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	ReviewInterface reviewInterface;

	@GetMapping("/list-books")
	public ResponseEntity<List<BookPojo>> getAllBooks() {
		List<BookPojo> books = bookService.getAllBooks();
		return ResponseEntity.ok(books);
	}

	@GetMapping("/{bookId}")
	public ResponseEntity<BookPojo> getBookById(@PathVariable Long bookId) {
		BookPojo book = bookService.getBookById(bookId);
		return ResponseEntity.ok(book);
	}

	// Second method for fetching a book with reviews
	@GetMapping("/book_id_review/{reviewBookId}") 
	public ResponseEntity<BookPojoReview> getBookAndReview(@PathVariable("reviewBookId") Long bookId) {
		BookPojoReview book = bookService.getBookByIdWithReview(bookId);
	
	
		return ResponseEntity.ok(book);
	}

	@PostMapping("/book")
	public ResponseEntity<BookPojo> addBook(@RequestBody BookPojo model) {
		BookPojo newBook = bookService.addBook(model);

		System.out.println(" added book " + model);
		return ResponseEntity.ok(newBook);
	}
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<BookPojo>> getBooksByUsers(@PathVariable Long userId){
//    	List<BookPojo> booksList=bookService.getBooksByUsers(userId);
//    	return ResponseEntity.ok(booksList);
//    }
}
