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

import com.onlinebookstore.book.model.BookModel;
import com.onlinebookstore.book.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        List<BookModel> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookModel> getBookById(@PathVariable Long bookId) {
    	BookModel book = bookService.getBookById(bookId);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<BookModel> addBook(@RequestBody BookModel model) {
    	BookModel newBook = bookService.addBook(model);
        return ResponseEntity.ok(newBook);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookModel>> getBooksByUsers(@PathVariable Long userId){
    	List<BookModel> booksList=bookService.getBooksByUsers(userId);
    	return ResponseEntity.ok(booksList);
    }
}

