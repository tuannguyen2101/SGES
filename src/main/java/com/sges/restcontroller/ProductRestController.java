package com.sges.restcontroller;

import com.sges.entity.Product;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import com.sges.service.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/products")
public class ProductRestController extends GenericController<Product, Integer> {

    final GenderDetailService genderDetailService;
    final ReviewsService reviewsService;
    final ComboDetailService comboDetailService;
    final ProductDetailService productDetailService;
    final ProductService productService;

    public ProductRestController(BaseService<Product, Integer> baseService, ProductService productService, ProductDetailService productDetailService, GenderDetailService genderDetailService, ReviewsService reviewsService, ComboDetailService comboDetailService) {
        super(baseService);
        this.productService = productService;
        this.productDetailService = productDetailService;
        this.genderDetailService = genderDetailService;
        this.reviewsService = reviewsService;
        this.comboDetailService = comboDetailService;
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize(value = "isAuthenticated()")
    public void delete(@PathVariable("id") Integer id) {
        genderDetailService.deleteGenderDetailByProduct_Id(id);
        reviewsService.deleteReviewsByProduct_Id(id);
        comboDetailService.deleteComboDetailByProductDetail_Id(id);
        productDetailService.deleteProductDetailByProduct_Id(id);
        productService.delete(id);
    }
}
