package com.example.ecommerceapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerceapp.entity.Product;
import com.example.ecommerceapp.repositry.ProductDAO;

@Service
public class ProductServiceImpl implements  ProductService{
	
	@Autowired
	ProductDAO productDAO;

	@Override
	public List<Product> findAll() {
		
		return productDAO.findAll();
	}

	@Override
	public void addProduct(Product p) {
		productDAO.save(p);
		
	}

	
	public Product findById(Integer prodid) {
		
		Optional<Product> p = productDAO.findById(prodid);
		Product product = null;
		
		if(p.isPresent())
			product = p.get();
		return product;
		
		
		
		
		
	}

	@Override
	public void deletProduct(Integer prodid) {
		productDAO.deleteById(prodid);
	}

	@Override
	public List<Product> findByCategory(Integer catid) {
		
		List<Product> findBycategoryid = productDAO.findBycategoryid(catid);
		System.out.println(findBycategoryid);
		return findBycategoryid;
	}

	@Override
	public List<Product> findByname(String name) {
		List<Product> product = null;
		if(name != null && name.trim().length() > 0) {
		product = productDAO.findBynameContainingIgnoreCase(name);
		}else {
			product = findAll();
		}
	
		return product;
	}

}
