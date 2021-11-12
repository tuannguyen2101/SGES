package com.sges.service.impl;

import com.sges.dto.OrderBy;
import com.sges.repo.ProductRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sges.entity.Product;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.ProductService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Integer> implements ProductService {

    final ProductRepo productRepo;

    public ProductServiceImpl(JpaRepository<Product, Integer> jpaRepository, ProductRepo productRepo) {
        super(jpaRepository);
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getNewProduct(OrderBy orderBy) {
        return productRepo.getTopByCreated(10);
    }

    @Override
    public List<Product> getTopByView() {
        return productRepo.getTopByView(12);
    }

    @Override
    public List<Product> getSaleProduct() {
        return productRepo.getBySaleGreaterThan(0);
    }

    @Override
    public List<Product> getByCategoryId(int id, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return productRepo.getBySubCate_SupCate_Id(id, pageable);
    }

    @Override
    public List<Product> filter(List<String> productName, List<Double> prices, boolean sortByPrice) {
            List<Product> productsList = new ArrayList<>();
            if(!productName.isEmpty()||!prices.isEmpty()){
                if (!productName.isEmpty()){
                    List<Product> productList= new ArrayList<>();
                    for (String product: productName){
                        productList.addAll(productsList.stream()
                        .filter(pro -> pro.getName().equals(product))
                        .collect(Collectors.toList()));
                    }
                    productsList = productList;
                }else {
                    productsList.addAll(productRepo.findByNameIn(productName));
                }
                if (!prices.isEmpty()){
                    productsList = productRepo.findByPriceBetween(prices.get(0),prices.get(1));
                }
            }else {
                productsList = productRepo.findAllByOrderByIdAsc();
            }
            if(sortByPrice){
                productsList.sort(Comparator.comparing(Product::getPrice));
            }else {
                productsList.sort((o1, o2) -> o2.getPrice().compareTo(o1.getPrice()));
            }

        return productsList;
    }
}
