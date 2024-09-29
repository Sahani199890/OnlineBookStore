package com.onlinebookstore.book.bookpojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookPojoReview {
	
	
	private BookPojo bookPojo;
	private ReviewPojo review;
	

}
