package com.sges.service.impl;

import com.sges.entity.ProductDetail;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.ProductDetailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailServiceImpl extends GenericServiceImpl<ProductDetail, Integer> implements ProductDetailService {

    public ProductDetailServiceImpl(JpaRepository<ProductDetail, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
