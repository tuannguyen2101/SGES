package com.sges.repo;

import org.springframework.stereotype.Repository;
import com.sges.entity.ProductDetail;

@Repository
public interface ProductDetailRepo extends BaseRepo<ProductDetail, Integer> {
    void deleteProductDetailByProduct_Id(Integer id);
    boolean existsProductDetailByProduct_Id(Integer id);
}
