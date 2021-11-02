package com.sges.service.impl;

import com.sges.repo.ProductRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sges.entity.Product;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.ProductService;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Integer> implements ProductService {

    final ProductRepo productRepo;

    public ProductServiceImpl(JpaRepository<Product, Integer> jpaRepository, ProductRepo productRepo) {
        super(jpaRepository);
        this.productRepo = productRepo;
    }
}
