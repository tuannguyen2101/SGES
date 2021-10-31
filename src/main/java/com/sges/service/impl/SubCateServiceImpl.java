package com.sges.service.impl;

import com.sges.entity.SubCate;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.SubCateService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SubCateServiceImpl extends GenericServiceImpl<SubCate, Integer> implements SubCateService {

    public SubCateServiceImpl(JpaRepository<SubCate, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
