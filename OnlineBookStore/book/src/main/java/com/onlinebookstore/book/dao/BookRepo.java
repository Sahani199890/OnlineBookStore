package com.onlinebookstore.book.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinebookstore.book.model.BookModel;

public interface BookRepo extends JpaRepository<BookModel, Long> {

//	List<BookModel> findByUserId(Long userId);

}
