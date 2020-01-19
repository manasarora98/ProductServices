package com.example.ProductMicroService.services;

import com.example.ProductMicroService.entity.CategoryEntity;
import com.example.ProductMicroService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServicesImpl implements CategoryServices {
    @Autowired
    CategoryRepository categoryRepository;

    public void addCategory(CategoryEntity categoryEntity){
        categoryRepository.save(categoryEntity);
    }


}
