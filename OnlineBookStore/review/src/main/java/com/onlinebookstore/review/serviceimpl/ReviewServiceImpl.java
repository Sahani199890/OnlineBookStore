package com.onlinebookstore.review.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.review.entity.Review;
import com.onlinebookstore.review.pojo.ReviewPojo;
import com.onlinebookstore.review.repo.ReviewRepo;
import com.onlinebookstore.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepo repo;

	@Override
	public ReviewPojo addReview(ReviewPojo pojo) {
		
		// TODO Auto-generated method stub
		Review review = new Review();
		BeanUtils.copyProperties(pojo, review);
		repo.save(review);
		return pojo;

	}

	@Override
	public List<ReviewPojo> listReviews() {
		// TODO Auto-generated method stub

		List<Review> reviews = repo.findAll();

		List<ReviewPojo> reviewPojoList = new ArrayList<>();
		for (Review review : reviews) {
			ReviewPojo reviewPojo = new ReviewPojo();
			BeanUtils.copyProperties(review, reviewPojo);
			reviewPojoList.add(reviewPojo);
		}

		return reviewPojoList;
	}

	@Override
	public ReviewPojo reveiwByBookId(Long id) {
		// TODO Auto-generated method stub
		
		Review review = repo.findbyBookId(id);
		
		ReviewPojo reviewPojo =new ReviewPojo();
		BeanUtils.copyProperties(review, reviewPojo);
		return reviewPojo;
	}


}
