package com.sges.service.impl;

import com.sges.entity.ComboDetail;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.ComboDetailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ComboDetailServiceImpl extends GenericServiceImpl<ComboDetail, Integer> implements ComboDetailService {

    public ComboDetailServiceImpl(JpaRepository<ComboDetail, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
