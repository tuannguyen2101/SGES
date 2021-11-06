package com.sges.service;

import com.sges.dto.OrderBy;
import com.sges.entity.Product;
import com.sges.generic.BaseService;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductService extends BaseService<Product, Integer> {
	List<Product> getNewProduct(OrderBy orderBy);
	List<Product> getTopByView();
	List<Product> getSaleProduct();
	List<Product> getByCategoryId(int id, int page);
}
