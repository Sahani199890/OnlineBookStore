package com.onlinebookstore.review.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId; // Unique ID for the review
	private Long bookId; // ID of the reviewed book  (one book multiple user reviews)
	private Long userId; // ID of the user who wrote the review
	private Integer rating; // Rating given by the user (1 to 5)
	private String comment; // User's review text
	private LocalDateTime reviewDate; // When the review was created
//    private Integer helpfulCount; // Number of helpful votes
//    private Boolean verifiedPurchase; // If the user bought the book
//    private String status;       // Review status (Pending, Approved, Rejected)

}
