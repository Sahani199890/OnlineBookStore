package com.onlinebookstore.book.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinebookstore.book.entity.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity, Long> {

	List<BookEntity> findByAuthor(String author);

	List<BookEntity> findByTitle(String title);

	List<BookEntity> findByBookDescription(String description);

//	List<BookModel> findByUserId(Long userId);

}
