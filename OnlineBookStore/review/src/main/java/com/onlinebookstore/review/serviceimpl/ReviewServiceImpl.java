package com.onlinebookstore.review.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlinebookstore.review.entity.Review;
import com.onlinebookstore.review.feign.UserInterface;
import com.onlinebookstore.review.pojo.ReviewPojo;
import com.onlinebookstore.review.pojo.UserDto;
import com.onlinebookstore.review.repo.ReviewRepo;
import com.onlinebookstore.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepo repo;

	@Autowired
	UserInterface userInterface;

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
	public List<ReviewPojo> reviewByBookId(Long id) {
	    List<Review> reviews = repo.findbyBookId(id);
	    List<ReviewPojo> reviewPojoList = new ArrayList<>();

	    for (Review review : reviews) {
	        ReviewPojo reviewPojo = new ReviewPojo();

	        // Copy properties directly from review to reviewPojo
	        BeanUtils.copyProperties(review, reviewPojo, "userDto"); // Exclude userDto for now

	        // Set additional fields
	        reviewPojo.setBookId(id);
	        
	        // Fetch user data and set userDto
	        Long userId = review.getUserId();
	        ResponseEntity<UserDto> userResponse = userInterface.getUserProfile(userId);
	        UserDto userData = userResponse.getBody();

	        // Create a new UserDto and copy properties
	        UserDto userDto = new UserDto();
	        if (userData != null) {
	            BeanUtils.copyProperties(userData, userDto);
	        }

	        reviewPojo.setUserDto(userDto);
	        reviewPojoList.add(reviewPojo);
	    }

	    return reviewPojoList;
	}


}
