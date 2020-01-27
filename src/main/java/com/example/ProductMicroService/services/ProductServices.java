package com.example.ProductMicroService.services;

import com.example.ProductMicroService.dto.ProductDTO;
import com.example.ProductMicroService.dto.ProductIdsWrapper;
import com.example.ProductMicroService.dto.ProductListDTO;
import com.example.ProductMicroService.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;


public interface ProductServices {

    ProductEntity createProducts(ProductEntity productEntity, ProductListDTO productListDTO);

    Page<ProductEntity> getProductsByCategory(Integer categoryId, PageRequest pageRequest);
    //String getCategoryName(Integer categoryId);

    List<ProductEntity> getAllProducts();

    Optional<ProductEntity> getProductById(String productId);

    List<ProductDTO> getProductsByIds(ProductIdsWrapper productIds);

    List<String> getNamesFeign(List<String> productIds);

    void setProductRating(String productId,double rating);


    void removeProduct(String productId);
}
