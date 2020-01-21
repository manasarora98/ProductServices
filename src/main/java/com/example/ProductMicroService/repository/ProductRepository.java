package com.example.ProductMicroService.repository;

import com.example.ProductMicroService.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,String> {

//    @Query("{'category_id : ?0'}")
//    List<ProductEntity> getProductsByCategory(int categoryId);
    List<ProductEntity> findAllByCategoryId(Integer categoryId);
}
