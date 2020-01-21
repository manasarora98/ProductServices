package com.example.ProductMicroService.services;

import com.example.ProductMicroService.dto.ProductDTO;
import com.example.ProductMicroService.dto.ProductIdsWrapper;
import com.example.ProductMicroService.dto.ProductListDTO;
import com.example.ProductMicroService.entity.ProductEntity;
import com.example.ProductMicroService.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImpl implements ProductServices{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private MerchantFeign merchantFeign;

    @Override
    public ProductEntity createProducts(ProductEntity productEntity, ProductListDTO productListDTO){

        productEntity= productRepository.save(productEntity);
        System.out.println("hello");

        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(productEntity, productDTO);
        //kafka part

        ObjectMapper objectMapper=new ObjectMapper();
        String object_to_string= new String();
        try{
            object_to_string=objectMapper.writeValueAsString(productDTO);
            System.out.println(object_to_string);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        this.kafkaTemplate.send("productUpdate",object_to_string);
          System.out.println(productEntity.toString() +" sent to kafka");
        //kafka part ends

        productListDTO.setProductId(productEntity.getProductId());
        Integer ret = merchantFeign.addProduct(productListDTO);
        // System.out.println(list);
        return productEntity;
    }

    @Override
    public List<ProductEntity> getProductsByCategory(Integer categoryId){
        return productRepository.findAllByCategoryId(categoryId);

    }

   /* @Override
    public Optional<ProductEntity> getProductsByProductId(Integer productId){
        return productRepository.findById(productId);
    }*/

    @Override
    public List<ProductEntity> getAllProducts(){
        return (List<ProductEntity>) productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> getProductById(String productId){
        return productRepository.findById(productId);
    }

    @Override
    public List<ProductDTO> getProductsByIds(ProductIdsWrapper productIds){
        List<ProductDTO> list = new ArrayList<>();
        for (String id:productIds.getProductIds()) {
            ProductDTO productDTO = new ProductDTO();
            Optional<ProductEntity> productEntity = productRepository.findById(id);
//            BeanUtils.copyProperties(productEntity,productDTO);
//
            ProductEntity productEntity1=productEntity.get();
            BeanUtils.copyProperties(productEntity1,productDTO);
            list.add(productDTO);
        }

        return list;
    }

    @Override
    public String getNamesFeign(String productId) {

        Optional<ProductEntity> productEntity = productRepository.findById(productId);
        return productEntity.get().getName();

    }




}
