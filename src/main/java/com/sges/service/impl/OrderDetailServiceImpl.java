package com.sges.service.impl;

import com.sges.entity.OrderDetail;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.OrderDetailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends GenericServiceImpl<OrderDetail, Integer> implements OrderDetailService {

    public OrderDetailServiceImpl(JpaRepository<OrderDetail, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
