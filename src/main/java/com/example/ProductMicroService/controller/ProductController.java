package com.example.ProductMicroService.controller;

import com.example.ProductMicroService.dto.CategoryDTO;
import com.example.ProductMicroService.dto.ProductDTO;
import com.example.ProductMicroService.entity.CategoryEntity;
import com.example.ProductMicroService.entity.ProductEntity;
import com.example.ProductMicroService.services.CategoryServices;
import com.example.ProductMicroService.services.ProductServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductServices productServices;
    @Autowired
    CategoryServices categoryServices;

    @PostMapping(value="/createProduct")
    public void createProduct(@RequestBody ProductDTO productDTO){
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productDTO,productEntity);
        ProductEntity productEntityCreated = productServices.createProducts(productEntity);
       // to do call merchantservice pass id parameter
    }

    @PostMapping(value="/addcategory")
    public void addCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(categoryDTO,categoryEntity);
        categoryServices.addCategory(categoryEntity);
    }

    @GetMapping(value="/showProducts/{id}")
    public List<ProductDTO> showProducts(@PathVariable ("id") int categoryId){
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<ProductEntity> list = productServices.getProductsByCategory(categoryId);
        for (ProductEntity productEntity: list) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productEntity, productDTO);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }


   // @GetMapping(value = "/")

}
