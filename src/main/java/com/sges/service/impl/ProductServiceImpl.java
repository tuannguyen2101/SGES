package com.sges.service.impl;

import com.sges.dto.OrderBy;
import com.sges.repo.ProductRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sges.entity.Product;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Integer> implements ProductService {

    final ProductRepo productRepo;

    public ProductServiceImpl(JpaRepository<Product, Integer> jpaRepository, ProductRepo productRepo) {
        super(jpaRepository);
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getNewProduct(OrderBy orderBy) {
        return productRepo.getTopByCreated(10);
    }

    @Override
    public List<Product> getTopByView() {
        return productRepo.getTopByView(12);
    }

    @Override
    public List<Product> getSaleProduct() {
        return productRepo.getBySaleGreaterThan(0);
    }

    @Override
    public List<Product> getByCategoryId(int id, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return productRepo.getBySubCate_SupCate_Id(id, pageable);
    }
}
