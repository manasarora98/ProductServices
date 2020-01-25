package com.example.ProductMicroService.services;

import com.example.ProductMicroService.dto.ProductListDTO;
import com.example.ProductMicroService.feign.response.ProductList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "merchantFeign", url = "http://172.16.20.131:8090/")
public interface MerchantFeign {

    @RequestMapping(method = RequestMethod.POST, value = "productList/addProduct")
     Integer addProduct(@RequestBody ProductListDTO productListDTO);
}
