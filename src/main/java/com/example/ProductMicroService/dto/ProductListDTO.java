package com.example.ProductMicroService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductListDTO {
    String productId;
    String merchantId;
    Integer stock;
    double price;
}
