package com.example.ProductMicroService.entity;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
@Getter
@Setter
@Document(collection = "Product")
public class ProductEntity {
    @Id
    String productId;
    Integer categoryId;
    String name;
    String description;
    Map<String,String> productAttributes;
    double productRating;
    int noOfSoldUnits;
    String imageUrl;


}
