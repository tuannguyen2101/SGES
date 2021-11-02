package com.sges.service.impl;

import com.sges.entity.Voucher;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.repo.VoucherRepo;
import com.sges.service.VoucherService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl extends GenericServiceImpl<Voucher, Integer> implements VoucherService {

    final VoucherRepo voucherRepo;

    public VoucherServiceImpl(JpaRepository<Voucher, Integer> jpaRepository, VoucherRepo voucherRepo) {
        super(jpaRepository);
        this.voucherRepo = voucherRepo;
    }

    @Override
    public void deleteByEvent_Id(Integer id) {
        if (voucherRepo.existsVoucherByEvent_Id(id)) {
            voucherRepo.deleteByEvent_Id(id);
        }
    }
}
