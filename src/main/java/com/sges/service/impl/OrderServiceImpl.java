package com.sges.service.impl;

import com.sges.entity.Order;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends GenericServiceImpl<Order, Integer> implements OrderService {

}
