package com.sges.controller;

import com.sges.entity.OrderDetail;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController extends GenericController<OrderDetail, Integer>{

    public OrderDetailController(BaseService<OrderDetail, Integer> baseService) {
        super(baseService);
    }
}
