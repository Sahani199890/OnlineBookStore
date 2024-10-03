package com.onlinebookstore.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "book_model")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long book_id;
	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;
	@Column(name = "price")
	private Double price;
	@Column(name = "genre")
	private String genre;
	@Column(name = "stock")
	private int stock;
	
	@Column(name="book_description")
	private String bookDescription;
	
	@Column(name="image_type")
	private String imageType;
	@Lob
	@Column(name="book_image")
	private byte[] bookImage;
	// private int userId;
	
	

//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

}
