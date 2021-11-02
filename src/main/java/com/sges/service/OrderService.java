package com.sges.service;

import com.sges.entity.Order;
import com.sges.generic.BaseService;

public interface OrderService extends BaseService<Order, Integer> {

    void deleteOrderByUser_Id(Integer id);
}
