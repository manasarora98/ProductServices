package com.example.ProductMicroService.services;

import com.example.ProductMicroService.entity.ProductEntity;
import com.example.ProductMicroService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity createProducts(ProductEntity productEntity){
        return productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> getProductsByCategory(Integer categoryId){
        return productRepository.findAllByCategoryId(categoryId);

    }



}
