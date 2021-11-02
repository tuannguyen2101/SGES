package com.sges.repo;

import org.springframework.stereotype.Repository;
import com.sges.entity.Order;

@Repository
public interface OrderRepo extends BaseRepo<Order, Integer> {

    void deleteOrderByUser_Id(Integer id);
    boolean existsOrderByUser_Id(Integer id);
}
