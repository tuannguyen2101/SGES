package com.sges.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.sges.entity.Product;

import java.util.List;

@Repository
public interface ProductRepo extends BaseRepo<Product, Integer> {
    List<Product> getTopByCreated(int top);

    List<Product> getTopByView(int top);

    List<Product> getBySaleGreaterThan(int sale);

    List<Product> getBySubCate_SupCate_Id(int id, Pageable pageable);
}
