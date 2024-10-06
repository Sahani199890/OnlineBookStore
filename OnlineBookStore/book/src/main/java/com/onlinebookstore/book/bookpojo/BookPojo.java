package com.onlinebookstore.book.bookpojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookPojo {
	private Long book_id;
	private String title;
	private String author;
	private Double price;
	private String genre;
	private int stock;
	private String bookDescription;
	private String imageType;

	
	private String bookImage;
//	private int userId;

}
