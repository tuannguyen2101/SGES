package com.sges.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sges.entity.Product;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.ProductService;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Integer> implements ProductService{

    public ProductServiceImpl(JpaRepository<Product, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
