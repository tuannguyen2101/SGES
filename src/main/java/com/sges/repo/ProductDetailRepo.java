package com.sges.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sges.entity.ProductDetail;

import java.util.List;

@Repository
public interface ProductDetailRepo extends BaseRepo<ProductDetail, Integer> {
    void deleteProductDetailByProduct_Id(Integer id);
    boolean existsProductDetailByProduct_Id(Integer id);

    @Query("select distinct o.size from ProductDetail o where o.product.id =:id")
    List<String> getSize (@Param("id") int id);

    @Query("select distinct o.color from ProductDetail o where o.product.id =:id")
    List<String> getColor (@Param("id") int id);

}
