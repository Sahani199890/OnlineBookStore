package com.onlinebookstore.review.pojo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewPojo {

	private Long reviewId; // Unique ID for the review
	private Long bookId; // ID of the reviewed book  (one book multiple user reviews)
	private Long userId; // ID of the user who wrote the review
	private Integer rating; // Rating given by the user (1 to 5)
	private String comment; // User's review text
	private LocalDateTime reviewDate; // When the review was created
	    private UserDto userDto; // User information
}
