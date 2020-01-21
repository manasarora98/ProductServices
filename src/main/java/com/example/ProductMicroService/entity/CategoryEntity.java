package com.example.ProductMicroService.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Category")
public class CategoryEntity {
    @Id
    String categoryId;
    String categoryName;


}
