package com.sges.repo;

import org.springframework.stereotype.Repository;
import com.sges.entity.OrderDetail;

@Repository
public interface OrderDetailRepo extends BaseRepo<OrderDetail, Integer> {
}
