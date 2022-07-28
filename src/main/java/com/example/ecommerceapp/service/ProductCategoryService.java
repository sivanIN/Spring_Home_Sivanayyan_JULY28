package com.example.ecommerceapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommerceapp.entity.ProductCategory;

@Service
public interface ProductCategoryService {

	List<ProductCategory> findAll();

	public void addCategory(ProductCategory pc);

	public ProductCategory findById(Integer catid);

	public void deleteCategory(Integer catid);
	
	

}
