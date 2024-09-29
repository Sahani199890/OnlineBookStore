package com.onlinebookstore.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderItem {
	@Id
	  Long bookId;
      int quantity;
	public OrderItem(Long bookId, int quantity) {
		super();
		this.bookId = bookId;
		this.quantity = quantity;
	}
	public OrderItem() {
		super();
	}
      
      
}
