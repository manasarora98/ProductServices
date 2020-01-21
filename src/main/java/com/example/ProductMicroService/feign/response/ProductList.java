package com.example.ProductMicroService.feign.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductList {
    Integer id;
    String productId;
    Integer merchantId;
    Integer stock;
    Double price;
}
