package com.onlinebookstore.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.order.dto.OrderPojo;
import com.onlinebookstore.order.entity.Order;
import com.onlinebookstore.order.service.OrderService;

import jakarta.ws.rs.PATCH;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/order")
	public OrderPojo saveOrder(@RequestBody OrderPojo orderPojo){
		return orderService.saveOrderRecord(orderPojo);
	}
	
	
	@GetMapping("/order")
	public List<OrderPojo> findAllOrders(){
		return orderService.getAllOrders();
	}
	
	
	@GetMapping("/order/{orderId}")
	public Optional<Order> findOrderById(@PathVariable Long orderId){
		return orderService.getOrderById(orderId);
	}
	

	@GetMapping("/order/{userId}")
	public List<OrderPojo> findByUserId(@PathVariable Long userId){
		return orderService.getOrderByUserId(userId);
	}
	
	@PatchMapping("/orders/{orderId}/status")
	public OrderPojo updateOrderStatus(@PathVariable long orderId , String status) {
		return orderService.updateOrderStatusById(orderId,status);
	}
	
	

}
