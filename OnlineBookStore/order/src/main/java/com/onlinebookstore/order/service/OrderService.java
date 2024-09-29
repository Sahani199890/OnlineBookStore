package com.onlinebookstore.order.service;

import java.util.List;
import java.util.Optional;

import com.onlinebookstore.order.dto.OrderPojo;
import com.onlinebookstore.order.entity.Order;

public interface OrderService {

	OrderPojo saveOrderRecord(OrderPojo orderPojo);

	List<OrderPojo> getAllOrders();

	Optional<Order> getOrderById(Long orderId);

	List<OrderPojo> getOrderByUserId(Long userId);

	OrderPojo updateOrderStatusById(long orderId, String status);

}
