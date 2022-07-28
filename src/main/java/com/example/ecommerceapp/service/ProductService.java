package com.example.ecommerceapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommerceapp.entity.Product;
import com.example.ecommerceapp.entity.ProductCategory;



@Service
public interface ProductService {
	
	List<Product> findAll();

	public void addProduct(Product p);

	public Product findById(Integer prodid);

	public void deletProduct(Integer prodid);

	public List<Product> findByCategory(Integer catid);

	public List<Product> findByname(String name);

	

	

}
