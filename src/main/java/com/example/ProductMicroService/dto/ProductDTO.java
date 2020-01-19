package com.example.ProductMicroService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
public class ProductDTO {
    Integer productId;
    Integer categoryId;
    String name;
    String description;
    Map<String,String> productAttributes;
    int totalStock;
    int productRating;
    int noOfSoldUnits;
    String imageUrl;
}
