package com.example.ProductMicroService.repository;

import com.example.ProductMicroService.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity,String> {

//    @Query("{'category_id : ?0'}")
//    List<ProductEntity> getProductsByCategory(int categoryId);
    Page<ProductEntity> findAllByCategoryId(Integer categoryId, PageRequest pageRequest);

    @Modifying
    @Query(value = "Update Product_entity set rating=?1 where product_id=?2")
    void setProductRating(String productId,double rating);
}
