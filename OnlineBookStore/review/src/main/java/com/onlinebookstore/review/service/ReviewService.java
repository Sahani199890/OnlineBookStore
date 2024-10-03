package com.onlinebookstore.review.service;

import java.util.List;

import com.onlinebookstore.review.pojo.ReviewPojo;

public interface ReviewService {

	ReviewPojo addReview(ReviewPojo pojo);

	List<ReviewPojo> listReviews();



List<ReviewPojo> reviewByBookId(Long id);



}
