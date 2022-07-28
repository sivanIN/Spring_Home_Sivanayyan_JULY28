package com.example.ecommerceapp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerceapp.entity.ProductCategory;


@Repository
public interface ProductCategoryDAO extends JpaRepository<ProductCategory, Integer>{

}
