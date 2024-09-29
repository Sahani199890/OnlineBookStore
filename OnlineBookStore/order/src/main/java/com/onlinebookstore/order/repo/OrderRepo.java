package com.onlinebookstore.order.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.order.dto.OrderPojo;
import com.onlinebookstore.order.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

	List<OrderPojo> findByUserId(Long userId);
	

}
