package com.sges.service.impl;

import com.sges.entity.ProductDetail;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.repo.ProductDetailRepo;
import com.sges.service.ProductDetailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailServiceImpl extends GenericServiceImpl<ProductDetail, Integer> implements ProductDetailService {

    final ProductDetailRepo productDetailRepo;

    public ProductDetailServiceImpl(JpaRepository<ProductDetail, Integer> jpaRepository, ProductDetailRepo productDetailRepo) {
        super(jpaRepository);
        this.productDetailRepo = productDetailRepo;
    }

    @Override
    public void deleteProductDetailByProduct_Id(Integer id) {
        if (productDetailRepo.existsProductDetailByProduct_Id(id)) {
            productDetailRepo.deleteProductDetailByProduct_Id(id);
        }
    }
}
