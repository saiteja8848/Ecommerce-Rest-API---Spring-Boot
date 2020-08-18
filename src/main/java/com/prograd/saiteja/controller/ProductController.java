package com.prograd.saiteja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prograd.saiteja.model.Product;
import com.prograd.saiteja.model.Subcategory;
import com.prograd.saiteja.repository.SubcategoryRepository;
import com.prograd.saiteja.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	SubcategoryRepository subcategoryRepository;

	@GetMapping("/getProducts")
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@GetMapping("/getProduct/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return productService.getProductById(id);
	}

	@PutMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return "product updated";
	}

	@PostMapping("/addProduct/{subcategoryId}")
	public String addProduct(@RequestBody Product product, @PathVariable("subcategoryId") int subcategoryId) {
		Optional<Subcategory> subcategory = subcategoryRepository.findById(subcategoryId);
		if (subcategory.isPresent()) {
			product.setSubcategory(subcategory.get());
			productService.saveProduct(product);
			return "product added";
		} else
			return "No Subcategory Found,So Product Cannot be Added";
	}
	
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);
		return "Product deleted";
	}



}
