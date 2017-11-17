package com.yang.service;


import com.yang.dao.entity.OrderEntity;
import com.yang.dao.repository.OrderRepository;
import com.yang.service.query.OrderQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity getOrder(Long id){
        return orderRepository.findOne(id);
    }

    /**
     * 订单列表
     * @return
     */
    public Page<OrderEntity> getListByCondition(OrderQuery  orderQuery){

        return null;
    }


}
