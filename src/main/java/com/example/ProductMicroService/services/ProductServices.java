package com.example.ProductMicroService.services;

import com.example.ProductMicroService.dto.ProductListDTO;
import com.example.ProductMicroService.entity.ProductEntity;

import java.util.List;


public interface ProductServices {

    ProductEntity createProducts(ProductEntity productEntity, ProductListDTO productListDTO);

    List<ProductEntity> getProductsByCategory(Integer categoryId);
    //String getCategoryName(Integer categoryId);
}
