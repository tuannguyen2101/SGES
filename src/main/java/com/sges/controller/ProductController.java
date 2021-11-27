package com.sges.controller;

import com.sges.dto.Metadata;
import com.sges.dto.OrderBy;
import com.sges.dto.ResponseDTO;
import com.sges.generic.BaseService;
import com.sges.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sges.entity.Product;
import com.sges.generic.impl.GenericController;

import java.util.List;
import java.util.Set;

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
    @ApiOperation(value = "Get Sale products", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success",response = Product.class),
            @ApiResponse(code = 401, message = "Not authorized!",response = Product.class),
            @ApiResponse(code = 403, message = "Forbidden!!!",response = Product.class),
            @ApiResponse(code = 404, message = "Not found!!!",response = Product.class)
    })
    public ResponseEntity<ResponseDTO<List<Product>>>  test (
    ) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(productService.getSaleProduct());
        return new ResponseEntity<ResponseDTO<List<Product>>>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getList")
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
    @GetMapping("/getTopView")
    @ApiOperation(value = "Get Top View", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success",response = Product.class),
            @ApiResponse(code = 401, message = "Not authorized!",response = Product.class),
            @ApiResponse(code = 403, message = "Forbidden!!!",response = Product.class),
            @ApiResponse(code = 404, message = "Not found!!!",response = Product.class)
    })
    public ResponseEntity<ResponseDTO<List<Product>>>  getTopView (
    ) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(productService.getTopByView());
        return new ResponseEntity<ResponseDTO<List<Product>>>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getBySubCate")
    @ApiOperation(value = "Get By Sub Category", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success",response = Product.class),
            @ApiResponse(code = 401, message = "Not authorized!",response = Product.class),
            @ApiResponse(code = 403, message = "Forbidden!!!",response = Product.class),
            @ApiResponse(code = 404, message = "Not found!!!",response = Product.class)
    })
    public ResponseEntity<ResponseDTO<List<Product>>>  getBySubCate (
            @RequestParam(value = "id",defaultValue = "1") int id,
            @RequestParam(value = "p",defaultValue = "0") int page
    ) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(productService.getByCategoryId(id, page));
        return new ResponseEntity<ResponseDTO<List<Product>>>(responseDTO, HttpStatus.OK);
    }

}
