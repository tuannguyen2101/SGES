package com.sges.service.impl;

import com.sges.entity.GenderDetail;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.GenderDetailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenderDetailServiceImpl extends GenericServiceImpl<GenderDetail, Integer> implements GenderDetailService {

    public GenderDetailServiceImpl(JpaRepository<GenderDetail, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
