package com.sges.restcontroller;

import com.sges.dto.Metadata;
import com.sges.dto.ResponseDTO;
import com.sges.entity.Product;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import com.sges.service.*;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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


    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<ResponseDTO<Page<Product>>> findAll(
            @RequestParam(value = "p", defaultValue = "0") int page,
            @RequestParam(value = "s", defaultValue = "10") int size,
            @RequestParam(value = "productName", required = false) String productName,
            @RequestParam(value = "subCate", required = false) Integer subCate,
            @RequestParam(value = "priceStart" , required = false) Double priceStart,
            @RequestParam(value = "priceEnd" , required = false) Double priceEnd,
            @RequestParam(value = "viewStart" , required = false) Integer viewStart,
            @RequestParam(value = "viewEnd",required = false) Integer viewEnd,
            @RequestParam(value = "fields", required = false) Set<String> fields) {


        ResponseDTO<Page<Product>> responseDTO = new ResponseDTO<>();


        Pageable pageable = PageRequest.of(page, size);
        Page<Product> p=productService.getProductList(pageable,productName,priceStart,priceEnd,viewStart,viewEnd,subCate);


        responseDTO.setData(p);
        responseDTO.setMetadata(new Metadata(p.getSize(), p.getTotalElements(), p.getTotalPages()));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
