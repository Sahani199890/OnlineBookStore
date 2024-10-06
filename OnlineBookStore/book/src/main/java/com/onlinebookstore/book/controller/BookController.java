package com.onlinebookstore.book.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinebookstore.book.bookpojo.BookPojo;
import com.onlinebookstore.book.bookpojo.BookPojoReview;
import com.onlinebookstore.book.service.BookService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/books")
public class BookController {


	// testing to raise PR using GIT CLI
	
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;

	}

	@GetMapping("/list-books")
	public ResponseEntity<List<BookPojo>> getAllBooks(HttpServletRequest request) {
		List<BookPojo> books = bookService.getAllBooks(request);
		return ResponseEntity.ok(books);
	}

	@GetMapping("/{bookId}")
	public ResponseEntity<BookPojo> getBookDetailsById(@PathVariable Long bookId, HttpServletRequest request) {
		// Fetch the book details without including the image bytes
		BookPojo book = bookService.getBookById(bookId, request);
		return ResponseEntity.ok(book);
	}

	@GetMapping("/{bookId}/image")
	public ResponseEntity<byte[]> getBookImageById(@PathVariable Long bookId, HttpServletRequest request) {
		// Fetch only the image data and return as byte array
		byte[] image = bookService.getBookImageById(bookId, request);
		BookPojo book = bookService.getBookById(bookId, request);
		return ResponseEntity.ok().contentType(MediaType.valueOf(book.getImageType())).body(image);
	}

	// Second method for fetching a book with reviews
	@GetMapping("/book_id_review/{reviewBookId}")
	public ResponseEntity<BookPojoReview> getBookAndReview(@PathVariable("reviewBookId") Long bookId) {
		BookPojoReview book = bookService.getBookByIdWithReview(bookId);

		return ResponseEntity.ok(book);
	}

//	@PostMapping("/book")
//	public ResponseEntity<BookPojo> addBook(@RequestBody BookPojo model) {
//		BookPojo newBook = bookService.addBook(model);
//
//		System.out.println(" added book " + model);
//		return ResponseEntity.ok(newBook);
//	}

	@PostMapping("/add")
	public ResponseEntity<BookPojo> addBook(@RequestParam("bookPojo") String bookPojoJson,
			@RequestParam("image") MultipartFile imageFile) {
		try {

			ObjectMapper objectMapper = new ObjectMapper();
			BookPojo bookPojo = objectMapper.readValue(bookPojoJson, BookPojo.class);

			bookService.addBookDataWithFile(bookPojo, imageFile);

			bookPojo.setImageType(imageFile.getContentType());
			// bookPojo.setBookImage(imageFile.getBytes());
			return ResponseEntity.ok(bookPojo);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<BookPojo>> getBooksByUsers(@PathVariable Long userId){
//    	List<BookPojo> booksList=bookService.getBooksByUsers(userId);
//    	return ResponseEntity.ok(booksList);
//    }

	@GetMapping("/book_by_author")
	public List<BookPojo> getBookByAuthor(@RequestParam(value = "author") String author, HttpServletRequest request) {
		return bookService.getBookByAuthor(author,request);
	}

	@GetMapping("/book_by_title")
	public List<BookPojo> getBookByTitle(@RequestParam(value = "title") String title, HttpServletRequest request) {
		return bookService.getBookByTitle(title,request);
	}

	@GetMapping("/book_by_description")
	public List<BookPojo> getBookByDescription(@RequestParam(value = "description") String description,
			HttpServletRequest request) {
		return bookService.getBookBy(description,request);
	}

}
