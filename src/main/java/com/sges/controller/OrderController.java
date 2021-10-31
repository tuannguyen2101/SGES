package com.sges.controller;

import com.sges.entity.Order;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController extends GenericController<Order, Integer>{

    public OrderController(BaseService<Order, Integer> baseService) {
        super(baseService);
    }
}
