package com.sges.service.impl;

import org.springframework.stereotype.Service;

import com.sges.entity.Product;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.ProductService;

@Service
public class ComboServiceImpl extends GenericServiceImpl<Product, Integer> implements ProductService{

}
