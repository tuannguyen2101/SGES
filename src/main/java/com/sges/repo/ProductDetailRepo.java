package com.sges.repo;

import com.sges.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sges.entity.ProductDetail;

@Repository
public interface ProductDetailRepo extends BaseRepo<ProductDetail, Integer> {
    void deleteProductDetailByProduct_Id(Integer id);
    boolean existsProductDetailByProduct_Id(Integer id);
//    @Query("SELECT p FROM  Product p " +
//            "WHERE (:sub_cate_id IS NULL OR (p.subCate.id = :sub_cate_id)) "+
//            "AND (:priceStart IS NULL OR ( p.price > :priceStart)) " +
//            "AND (:priceEnd IS NULL OR ( p.price < :priceEnd)) " +
//            "AND (:productName IS NULL OR UPPER(p.name) LIKE CONCAT('%',UPPER(:productName),'%'))")
//    Page<Product> getListProductByCategoryOrProductNameContaining(Pageable pageable,
//
//                                                                  @Param("sub_cate_id") Integer sub_cate_id,
//                                                                  @Param("priceStart") Double priceStart,
//                                                                  @Param("priceEnd") Double priceEnd,
//                                                                  @Param("productName") String productName);

}
