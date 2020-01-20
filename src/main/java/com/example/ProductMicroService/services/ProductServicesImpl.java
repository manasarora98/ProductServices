package com.example.ProductMicroService.services;

import com.example.ProductMicroService.dto.ProductListDTO;
import com.example.ProductMicroService.entity.ProductEntity;
import com.example.ProductMicroService.feign.response.ProductList;
import com.example.ProductMicroService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MerchantFeign merchantFeign;

    @Override
    public ProductEntity createProducts(ProductEntity productEntity, ProductListDTO productListDTO){

        ProductEntity productEntity1= productRepository.save(productEntity);
        productListDTO.setProductId(productEntity1.getProductId());
        Integer ret = merchantFeign.addProduct(productListDTO);
       // System.out.println(list);
        return productEntity;
    }

    @Override
    public List<ProductEntity> getProductsByCategory(Integer categoryId){
        return productRepository.findAllByCategoryId(categoryId);

    }



}
