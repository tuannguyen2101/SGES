package com.sges.controller;

import com.sges.dto.OrderBy;
import com.sges.dto.ResponseDTO;
import com.sges.generic.BaseService;
import com.sges.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sges.entity.Product;
import com.sges.generic.impl.GenericController;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController extends GenericController<Product, Integer>{

    private final ProductService productService;

    public ProductController(ProductService productService) {
        super(productService);
        this.productService = productService;
    }

//    @PostMapping("/getNewProducts")
//    public ResponseEntity<ResponseDTO<List<Product>>>  test (
//            @RequestBody OrderBy orderBy
//    ) {
//        ResponseDTO responseDTO = new ResponseDTO();
//        List<Product> productList = this.productService.getNewProduct(orderBy);
//    }

    @GetMapping("/getSaleProducts")
    public ResponseEntity<ResponseDTO<List<Product>>>  test (
    ) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(productService.getSaleProduct());
        return new ResponseEntity<ResponseDTO<List<Product>>>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getTopView")
    public ResponseEntity<ResponseDTO<List<Product>>>  getTopView (
    ) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(productService.getTopByView());
        return new ResponseEntity<ResponseDTO<List<Product>>>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getBySubCate")
    public ResponseEntity<ResponseDTO<List<Product>>>  getBySubCate (
            @RequestParam(value = "id",defaultValue = "1") int id,
            @RequestParam(value = "p",defaultValue = "0") int page
    ) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(productService.getByCategoryId(id, page));
        return new ResponseEntity<ResponseDTO<List<Product>>>(responseDTO, HttpStatus.OK);
    }

}
