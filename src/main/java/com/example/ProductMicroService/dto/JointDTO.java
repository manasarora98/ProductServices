package com.example.ProductMicroService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter

public class JointDTO {
   // String productId;
    Integer categoryId;
    String name;
    String description;
    Map<String,String> productAttributes;
    //int productRating;
    //int noOfSoldUnits;
    String imageUrl;
    String merchantId;
    Integer stock;
    Double price;
}
