package com.example.ecommerceapp.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerceapp.entity.Product;


@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{
	
	List<Product> findBycategoryid(Integer catid);
	List<Product> findBynameContainingIgnoreCase(String name);

}
