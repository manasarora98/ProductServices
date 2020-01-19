package com.example.ProductMicroService.repository;

import com.example.ProductMicroService.entity.CategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryEntity,String> {


}
