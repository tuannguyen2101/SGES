package com.sges.service;

import com.sges.dto.OrderBy;
import com.sges.entity.Product;
import com.sges.generic.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService extends BaseService<Product, Integer> {
	List<Product> getNewProduct(OrderBy orderBy);
	List<Product> getTopByView();
	List<Product> getSaleProduct();
	List<Product> getByCategoryId(int id, int page);
	List<Product> filter(List<String> productName, List<Double> prices,boolean sortByPrice);
	Page<Product> getProductList(Pageable pageable , String productName,Double priceStart,Double priceEnd ,Integer viewStart, Integer viewEnd, Integer sub_cate_id);

}
