package com.onlinebookstore.book.bookpojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookPojoReview {
	
	
	private BookPojo bookPojo;
	private List<ReviewPojo> review;
	

}
