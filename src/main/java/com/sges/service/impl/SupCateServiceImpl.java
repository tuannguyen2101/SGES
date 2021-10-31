package com.sges.service.impl;

import com.sges.entity.SupCate;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.SupCateService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SupCateServiceImpl extends GenericServiceImpl<SupCate, Integer> implements SupCateService {

    public SupCateServiceImpl(JpaRepository<SupCate, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
