package com.example.ProductMicroService.controller;

import com.example.ProductMicroService.dto.*;
import com.example.ProductMicroService.entity.ProductEntity;
import com.example.ProductMicroService.services.CategoryServices;
import com.example.ProductMicroService.services.ProductServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServices productServices;
    @Autowired
    CategoryServices categoryServices;

    @PostMapping(value = "/createProduct")
    public boolean createProduct(@RequestBody JointDTO jointDTO) {
        log.info("Request received : {}", jointDTO);
        ProductDTO productDTO = new ProductDTO();
        ProductListDTO productListDTO = new ProductListDTO();


        productDTO.setCategoryId(jointDTO.getCategoryId());
        productDTO.setDescription(jointDTO.getDescription());
        productDTO.setImageUrl(jointDTO.getImageUrl());
        productDTO.setName(jointDTO.getName());
        // productDTO.setNoOfSoldUnits(jointDTO.getNoOfSoldUnits());
        productDTO.setProductAttributes(jointDTO.getProductAttributes());
        //  productDTO.setProductRating(jointDTO.getProductRating());

        productListDTO.setMerchantId(jointDTO.getMerchantId());
        productListDTO.setPrice(jointDTO.getPrice());
        productListDTO.setStock(jointDTO.getStock());


        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productDTO, productEntity);

        ProductEntity productEntityCreated = productServices.createProducts(productEntity, productListDTO);
        return true;

    }

    /* @PostMapping(value="/addcategory")
     public void addCategory(@RequestBody CategoryDTO categoryDTO){
         CategoryEntity categoryEntity = new CategoryEntity();
         BeanUtils.copyProperties(categoryDTO,categoryEntity);
         categoryServices.addCategory(categoryEntity);
     }*/
    ///Get product List By Category ID
    @GetMapping(value = "/showProducts/{id}")
    public Page<ProductEntity> showProducts(@PathVariable("id") int categoryId, @RequestParam Integer pageSize, @RequestParam Integer pageNo) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        Page<ProductEntity> list = productServices.getProductsByCategory(categoryId, PageRequest.of(pageNo, pageSize));
        return list;
    }

    @GetMapping(value = "/getAllProducts")
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<ProductEntity> list = productServices.getAllProducts();
        for (ProductEntity productEntity : list) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productEntity, productDTO);
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }

    @GetMapping(value = "/getProductById/{id}")
    public Optional<ProductEntity> getProductById(@PathVariable("productId") String productId) {
        return productServices.getProductById(productId);
    }


    @PostMapping(value = "/getProductsByIds")
    public List<ProductDTO> getProductsByIds(@RequestBody ProductIdsWrapper productIds) {
        return productServices.getProductsByIds(productIds);

    }

    @PostMapping(value = "/getNamesFeign")
    public List<String> getNamesFeign(@RequestBody List<String> productIds) {
        return productServices.getNamesFeign(productIds);
    }

    @PostMapping(value = "/setProductRating/{productId}/{rating}")
    public boolean setProductRating(@PathVariable("productId") String productId,@PathVariable("rating") double rating){
        productServices.setProductRating(productId,rating);
        return true;
    }




}
