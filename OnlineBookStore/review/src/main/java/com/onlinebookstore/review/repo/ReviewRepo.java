package com.onlinebookstore.review.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.review.entity.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

	@Query(value = "SELECT * \r\n" + "FROM REVIEW \r\n" + "WHERE BOOK_ID = :id;\r\n" + "", nativeQuery = true)
	List<Review> findbyBookId(Long id);

}
