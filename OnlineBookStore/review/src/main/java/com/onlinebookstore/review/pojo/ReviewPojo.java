package com.onlinebookstore.review.pojo;

import java.time.LocalDateTime;

public class ReviewPojo {
	private Long reviewId;       // Unique ID for the review
    private Long bookId;         // ID of the reviewed book
    private Long userId;         // ID of the user who wrote the review
    private Integer rating;      // Rating given by the user (1 to 5)
    private String comment;      // User's review text
    private LocalDateTime reviewDate; // When the review was created
	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDateTime getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(LocalDateTime reviewDate) {
		this.reviewDate = reviewDate;
	}
	public ReviewPojo(Long reviewId, Long bookId, Long userId, Integer rating, String comment,
			LocalDateTime reviewDate) {
		super();
		this.reviewId = reviewId;
		this.bookId = bookId;
		this.userId = userId;
		this.rating = rating;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}
	public ReviewPojo() {
		super();
	}
    
    
}
