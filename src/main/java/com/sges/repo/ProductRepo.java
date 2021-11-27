package com.sges.repo;

import io.swagger.models.auth.In;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sges.entity.Product;

import java.util.List;

@Repository
public interface ProductRepo extends BaseRepo<Product, Integer> {
    List<Product> getTopByCreated(int top);

    List<Product> getTopByView(int top);

    List<Product> getBySaleGreaterThan(int sale);

    List<Product> getBySubCate_SupCate_Id(int id, Pageable pageable);

    List<Product> findByNameIn(List<String> name);

    List<Product> findByPriceBetween(Double startingPrice,Double endingPrice);

    List<Product> findAllByOrderByIdAsc();

    @Query("SELECT p FROM  Product p " +
            "WHERE (:sub_cate_id IS NULL OR (p.subCate.id = :sub_cate_id)) "+
            "AND (:priceStart IS NULL OR ( p.price > :priceStart)) " +
            "AND (:priceEnd IS NULL OR ( p.price < :priceEnd)) " +
            "AND (:viewStart IS NULL OR ( p.view > :viewStart)) " +
            "AND (:viewEnd IS NULL OR ( p.view < :viewEnd)) " +
            "AND (:productName IS NULL OR UPPER(p.name) LIKE CONCAT('%',UPPER(:productName),'%'))")
    Page<Product> getListProductByCategoryOrProductNameContaining(Pageable pageable,

                                                                  @Param("sub_cate_id") Integer sub_cate_id,
                                                                  @Param("priceStart") Double priceStart,
                                                                  @Param("priceEnd") Double priceEnd,
                                                                  @Param("viewStart") Integer viewStart,
                                                                  @Param("viewEnd") Integer viewEnd,
                                                                  @Param("productName") String productName);

}
