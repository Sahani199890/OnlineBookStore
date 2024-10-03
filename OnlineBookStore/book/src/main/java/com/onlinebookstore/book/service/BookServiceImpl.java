package com.onlinebookstore.book.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onlinebookstore.book.bookpojo.BookPojo;
import com.onlinebookstore.book.bookpojo.BookPojoReview;
import com.onlinebookstore.book.bookpojo.ReviewPojo;
import com.onlinebookstore.book.entity.BookEntity;
import com.onlinebookstore.book.feignclinet.ReviewInterface;
import com.onlinebookstore.book.helper.ManualException;
import com.onlinebookstore.book.repo.BookRepo;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepo repo;

	private final ReviewInterface reviewInterface;

	public BookServiceImpl(BookRepo repo, ReviewInterface reviewInterface) {
		super();
		this.repo = repo;
		this.reviewInterface = reviewInterface;
	}

	@Override
	public BookPojo getBookById(Long bookId, HttpServletRequest request) {
		// Fetch book data without fetching image
		BookEntity bookEntity = repo.findById(bookId).orElseThrow(() -> new ManualException("Book not found"));

		// Convert BookEntity to BookPojo
		BookPojo bookPojo = new BookPojo();
		BeanUtils.copyProperties(bookEntity, bookPojo);

		String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		String imageUrl = baseUrl + "/books/" + bookId + "/image";

		// Exclude image from the Pojo to avoid huge base64 encoding in JSON response
		bookPojo.setBookImage(imageUrl);
		return bookPojo;
	}

	@Override
	public byte[] getBookImageById(Long bookId, HttpServletRequest request) {
		// Fetch only image from the database
		BookEntity bookEntity = repo.findById(bookId).orElseThrow(() -> new ManualException("Book not found"));
		return bookEntity.getBookImage();
	}

	public List<BookPojo> getAllBooks(HttpServletRequest request) {
		List<BookEntity> bookList = repo.findAll();

		List<BookPojo> bookPojoList = new ArrayList<>();
		for (BookEntity bookEntity : bookList) {

			String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
			String imageUrl = baseUrl + "/books/" + bookEntity.getBook_id() + "/image";

			BookPojo bookPojo = new BookPojo();
			BeanUtils.copyProperties(bookEntity, bookPojo);
			bookPojo.setBookImage(imageUrl);
			bookPojoList.add(bookPojo);

		}

		return bookPojoList;
	}

	public BookPojo addBook(BookPojo model) {

		BookEntity BookEntity = new BookEntity();
		BeanUtils.copyProperties(model, BookEntity);
		repo.save(BookEntity);
		return model;

	}

	public BookPojoReview getBookByIdWithReview(Long bookId) {
		// TODO Auto-generated method stub

		BookEntity book = repo.findById(bookId).get();
		BookPojo bookPojo = new BookPojo();
		BeanUtils.copyProperties(book, bookPojo);

		// ReviewPojo reviewPojo = reviewInterface.reviewByBookId(bookId);
		// BookPojoReview bookPojoReview = new BookPojoReview(bookPojo, reviewPojo);
		List<ReviewPojo> list = reviewInterface.reviewByBookId(bookId);
		BookPojoReview bookPojoReview = new BookPojoReview(bookPojo, list);
		return bookPojoReview;
	}

	@Override
	public void addBookDataWithFile(BookPojo bookPojo, MultipartFile imageFile) {
		try {
			// Create a new BookEntity object to map data from BookPojo
			BookEntity bookEntity = new BookEntity();
			BeanUtils.copyProperties(bookPojo, bookEntity);

			if (imageFile != null && !imageFile.isEmpty()) {
				bookEntity.setImageType(imageFile.getContentType());
				bookEntity.setBookImage(imageFile.getBytes());
			}

			repo.save(bookEntity);

		} catch (IOException e) {

			throw new RuntimeException("Failed to save image file", e);
		} catch (Exception e) {

			throw new RuntimeException("Failed to save book data", e);
		}
	}

	@Override
	public List<BookPojo> getBookByAuthor(String author, HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<BookEntity> bookList = repo.findByAuthor(author);

		List<BookPojo> bookPojoList = new ArrayList<>();
		for (BookEntity bookEntity : bookList) {
			String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
			String imageUrl = baseUrl + "/books/" + bookEntity.getBook_id() + "/image";

			BookPojo bookPojo = new BookPojo();
			BeanUtils.copyProperties(bookEntity, bookPojo);
			bookPojo.setBookImage(imageUrl);
			bookPojoList.add(bookPojo);
		}

		return bookPojoList;

	}

	@Override
	public List<BookPojo> getBookByTitle(String title, HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<BookEntity> bookList = repo.findByTitle(title);
		List<BookPojo> bookPojoList = new ArrayList<>();
		for (BookEntity bookEntity : bookList) {

			String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
			String imageUrl = baseUrl + "/books/" + bookEntity.getBook_id() + "/image";

			BookPojo bookPojo = new BookPojo();
			BeanUtils.copyProperties(bookEntity, bookPojo);
			bookPojo.setBookImage(imageUrl);
			bookPojoList.add(bookPojo);
		}

		return bookPojoList;

	}

	@Override
	public List<BookPojo> getBookBy(String description, HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<BookEntity> bookList = repo.findByBookDescription(description);
		List<BookPojo> bookPojoList = new ArrayList<>();
		for (BookEntity bookEntity : bookList) {
			String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
			String imageUrl = baseUrl + "/books/" + bookEntity.getBook_id() + "/image";

			BookPojo bookPojo = new BookPojo();
			BeanUtils.copyProperties(bookEntity, bookPojo);
			bookPojo.setBookImage(imageUrl);
			bookPojoList.add(bookPojo);

		}

		return bookPojoList;

	}

//	@Override
//	public List<BookPojo> getBooksByUsers(Long userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
