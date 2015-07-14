package com.mum.edu.happycart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.domain.Order;
import com.mum.edu.happycart.repository.OrderRepository;
import com.mum.edu.happycart.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	
	public void saveOrder(Order order) {
	   	orderRepository.save(order);
	}

}
