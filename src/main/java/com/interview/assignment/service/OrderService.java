package com.interview.assignment.service;

import java.util.List;

import com.interview.assignment.entity.Order;

public interface OrderService {
	
	Order getOrder(int order_id);
	List<Order> listOrders();
	int saveOrder(Order order);
	void deleteOrder(int order_id);
	
}
