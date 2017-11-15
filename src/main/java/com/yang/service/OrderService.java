package com.yang.service;


import com.yang.dao.entity.Order;
import com.yang.dao.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrder(Long id){
        return orderRepository.findOne(id);
    }
}
