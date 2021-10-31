package com.sges.service.impl;

import com.sges.entity.Order;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends GenericServiceImpl<Order, Integer> implements OrderService {

    public OrderServiceImpl(JpaRepository<Order, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
