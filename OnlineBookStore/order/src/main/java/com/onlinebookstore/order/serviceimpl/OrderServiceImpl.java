package com.onlinebookstore.order.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.onlinebookstore.order.dto.OrderPojo;
import com.onlinebookstore.order.entity.Order;
import com.onlinebookstore.order.repo.OrderRepo;
import com.onlinebookstore.order.service.OrderService;

public class OrderServiceImpl implements OrderService {

	
	@Autowired
	OrderRepo orderRepo;

	@Override
	public OrderPojo saveOrderRecord(OrderPojo orderPojo) {
		// TODO Auto-generated method stub
		
		Order order=new Order();
		BeanUtils.copyProperties(orderPojo, order);
		Order data = orderRepo.save(order);
		return orderPojo;
	}

	@Override
	public List<OrderPojo> getAllOrders() {
		// TODO Auto-generated method stub
		List<Order> order = orderRepo.findAll();
		List<OrderPojo> orderPojo=new ArrayList<>();
		for (Order order2 : order) {
			OrderPojo oderPojoData=new OrderPojo();
			BeanUtils.copyProperties(order2, oderPojoData);
			orderPojo.add(oderPojoData);
		}
		
		return orderPojo;
	}

	@Override
	public Optional<Order> getOrderById(Long orderId) {
		// TODO Auto-generated method stub
		return orderRepo.findById(orderId);
	}

	@Override
	public List<OrderPojo> getOrderByUserId(Long userId) {
		// TODO Auto-generated method stub
		return orderRepo.findByUserId(userId);
	}

	@Override
	public OrderPojo updateOrderStatusById(long orderId, String status) {
		// TODO Auto-generated method stub
		
		Optional<Order> data = orderRepo.findById(orderId);
		data.get().setStatus(status);
		OrderPojo orderPojo =new OrderPojo();
		BeanUtils.copyProperties(data, orderPojo);
		
		return orderPojo;
	}
	
	
}
