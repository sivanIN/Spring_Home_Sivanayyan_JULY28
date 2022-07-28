package com.example.ecommerceapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerceapp.entity.ProductCategory;
import com.example.ecommerceapp.repositry.ProductCategoryDAO;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	
	@Autowired
	ProductCategoryDAO productCategoryDAO;

	@Override
	public List<ProductCategory> findAll() {
		// TODO Auto-generated method stub
		return productCategoryDAO.findAll();
	}

	@Override
	public void addCategory(ProductCategory pc) {
		productCategoryDAO.save(pc);
		
	}

	@Override
	public ProductCategory findById(Integer catid) {
		Optional<ProductCategory> pc = productCategoryDAO.findById(catid);
		ProductCategory productCategory = null;
		if(pc.isPresent())
			productCategory = pc.get();
		return productCategory;
	}

	@Override
	public void deleteCategory(Integer catid) {
		productCategoryDAO.deleteById(catid);
		
	}

}
