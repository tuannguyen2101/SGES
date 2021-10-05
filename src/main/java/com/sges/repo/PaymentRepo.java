package com.sges.repo;

import org.springframework.stereotype.Repository;
import com.sges.entity.Payment;

@Repository
public interface PaymentRepo extends BaseRepo<Payment, Integer> {
}
