package com.onlinebookstore.order.dto;

import java.util.List;

import com.onlinebookstore.order.entity.OrderItem;

public class OrderPojo {
	private Long id;
	private Long userId;
	private List<OrderItem> items;
	private Double totalPrice;
	private String status;

	public OrderPojo(Long id, Long userId, List<OrderItem> items, Double totalPrice, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.items = items;
		this.totalPrice = totalPrice;
		this.status = status;
	}

	public OrderPojo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
