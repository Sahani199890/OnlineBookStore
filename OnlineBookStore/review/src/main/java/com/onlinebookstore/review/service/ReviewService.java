package com.onlinebookstore.review.service;

import java.util.List;

import com.onlinebookstore.review.pojo.ReviewPojo;

public interface ReviewService {

	ReviewPojo addReview(ReviewPojo pojo);

	List<ReviewPojo> listReviews();

ReviewPojo reveiwByBookId(Long id);



}
