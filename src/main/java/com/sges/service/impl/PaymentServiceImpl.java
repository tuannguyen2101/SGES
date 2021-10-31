package com.sges.service.impl;

import com.sges.entity.Payment;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.PaymentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends GenericServiceImpl<Payment, Integer> implements PaymentService {

    public PaymentServiceImpl(JpaRepository<Payment, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
