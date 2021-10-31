package com.sges.service.impl;

import com.sges.entity.Voucher;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.VoucherService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl extends GenericServiceImpl<Voucher, Integer> implements VoucherService {

    public VoucherServiceImpl(JpaRepository<Voucher, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
