package com.sges.repo;

import org.springframework.stereotype.Repository;
import com.sges.entity.Product;

@Repository
public interface ProductRepo extends BaseRepo<Product, Integer> {
}
