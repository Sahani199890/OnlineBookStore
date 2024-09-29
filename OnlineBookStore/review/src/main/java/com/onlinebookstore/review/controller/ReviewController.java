package com.onlinebookstore.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.review.pojo.ReviewPojo;
import com.onlinebookstore.review.service.ReviewService;

@RestController
//@RequestMapping("/review")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@PostMapping("/review")
	public ReviewPojo addReview(@RequestBody ReviewPojo pojo) {

		return reviewService.addReview(pojo);
	}

	@GetMapping("/review")
	public List<ReviewPojo> listReviewPojo() {
		return reviewService.listReviews();
	}

	@GetMapping("/review_by_book_id/{bookId}")
    public ReviewPojo reviewByBookId(@PathVariable("bookId") Long id)   {
		return reviewService.reveiwByBookId(id);
	}

}
