package com.sges.controller;

import com.sges.generic.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sges.entity.Product;
import com.sges.generic.impl.GenericController;

@RestController
@RequestMapping("/product")
public class ProductController extends GenericController<Product, Integer>{

    public ProductController(BaseService<Product, Integer> baseService) {
        super(baseService);
    }
}
