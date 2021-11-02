package com.sges.service.impl;

import com.sges.entity.Order;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.repo.OrderRepo;
import com.sges.service.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends GenericServiceImpl<Order, Integer> implements OrderService {

    final OrderRepo orderRepo;

    public OrderServiceImpl(JpaRepository<Order, Integer> jpaRepository, OrderRepo orderRepo) {
        super(jpaRepository);
        this.orderRepo = orderRepo;
    }

    @Override
    public void deleteOrderByUser_Id(Integer id) {
        if (orderRepo.existsOrderByUser_Id(id)) {
            orderRepo.deleteOrderByUser_Id(id);
        }
    }


}
