package com.sges.repo;

import org.springframework.stereotype.Repository;
import com.sges.entity.Voucher;

@Repository
public interface VoucherRepo extends BaseRepo<Voucher, Integer> {
    void deleteByEvent_Id(Integer id);
    boolean existsVoucherByEvent_Id(Integer id);
    Voucher getByCode(String code);
}
