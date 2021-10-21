package com.sges.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sges.entity.Product;
import com.sges.generic.impl.GenericController;

@RestController
@RequestMapping("/product")
public class AddressController extends GenericController<Product, Integer>{

}
