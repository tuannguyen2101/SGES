package com.sges.controller;

import com.sges.entity.ProductDetail;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productDetail")
public class ProductDetailController extends GenericController<ProductDetail, Integer>{

}
