package com.example.ecommerceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecommerceapp.entity.Product;
import com.example.ecommerceapp.entity.ProductCategory;
import com.example.ecommerceapp.service.ProductCategoryService;
import com.example.ecommerceapp.service.ProductService;

@Controller
@RequestMapping("/App")
public class EcommerceAppController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	@GetMapping("/products")
	public String displayAllProduct(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("PRODUCT", products);
		return "AppFrontend/products.html";
	}
	
	@GetMapping("/showFormForAdd")
	public String productForm(Model model) {
		model.addAttribute("PRODUCT",new Product());
		return "AppFrontend/newprodform.html";
		
		
	}
	
	@PostMapping("/newproduct")
	public String addProduct(@ModelAttribute Product p) {
		
		productService.addProduct(p);
		return "redirect:/App/products";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public  String updateProduct(@RequestParam("prodid") Integer prodid,Model model) {
		System.out.println("test");
		System.out.println(prodid);
		
		Product product = productService.findById(prodid);
		
		System.out.println(product);
		
		productService.addProduct(product);
		model.addAttribute("PRODUCT",product);
		return "AppFrontend/newprodform.html";
		
		
	}
	
	@GetMapping("/delete")
	public String  deleteProduct(@RequestParam("prodid") Integer prodid) {
		
		productService.deletProduct(prodid);
		return "redirect:/App/products";
		
	}
	
	@GetMapping("/bycategory")
	public String productByCategory(@RequestParam("catid") Integer catid,Model model) {
		System.out.println(catid);
		List<Product> product = productService.findByCategory(catid);
		model.addAttribute("PRODUCT",product);
		return  "AppFrontend/products.html";
		
	}
	
	@GetMapping("/byname")
	public String searchByProductname(@RequestParam("name") String name,Model model) {
		
		List<Product> product = productService.findByname(name);
		model.addAttribute("PRODUCT",product);
		return  "AppFrontend/products.html";
		
	}
	
	
//	Product Category
	
	@GetMapping("/category")
	public String displayAllProCategory(Model model) {
		
		List<ProductCategory> prodcategory = productCategoryService.findAll();
		model.addAttribute("CATEGORY",prodcategory);
		return "AppFrontend/productcategory.html";
		
	}
	
	@GetMapping("/categoryFormForAdd")
	public String CategoryForm(Model model) {
		model.addAttribute("CATEGORY",new ProductCategory());
		return "AppFrontend/newcategoryform.html";
			
	}
	
	@PostMapping("/newCategory")
	public String addcategory(@ModelAttribute ProductCategory pc) {
		
		productCategoryService.addCategory(pc);
		return "redirect:/App/category";
		
	}
	
	@GetMapping("/categoryFormForUpdate")
	public  String updateCategory(@RequestParam("catid") Integer catid,Model model) {
		
		ProductCategory productCategory = productCategoryService.findById(catid);
		productCategoryService.addCategory(productCategory);
		model.addAttribute("CATEGORY",productCategory);
		return "AppFrontend/newcategoryform.html";
		
	}
	
	@GetMapping("/deletecategory")
	public String  deleteCategory(@RequestParam("catid") Integer catid) {
		
		productCategoryService.deleteCategory(catid);
		
		return "redirect:/App/category";
		
	}
	

}
