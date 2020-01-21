package com.example.ProductMicroService.services;

import com.example.ProductMicroService.dto.ProductDTO;
import com.example.ProductMicroService.dto.ProductIdsWrapper;
import com.example.ProductMicroService.dto.ProductListDTO;
import com.example.ProductMicroService.entity.ProductEntity;

import java.util.List;
import java.util.Optional;


public interface ProductServices {

    ProductEntity createProducts(ProductEntity productEntity, ProductListDTO productListDTO);

    List<ProductEntity> getProductsByCategory(Integer categoryId);
    //String getCategoryName(Integer categoryId);

    List<ProductEntity> getAllProducts();

    Optional<ProductEntity> getProductById(String productId);

    List<ProductDTO> getProductsByIds(ProductIdsWrapper productIds);

    String getNamesFeign(String productId);


}
