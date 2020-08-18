package com.prograd.saiteja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prograd.saiteja.model.Product;
import com.prograd.saiteja.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public void saveProducts(List<Product> products) {
		productRepository.saveAll(products);
	}

	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}

	public void updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getProductId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setImageUrl(product.getImageUrl());
		existingProduct.setCounter(product.getCounter());
		existingProduct.setClickStatus(product.isClickStatus());
		productRepository.save(existingProduct);
	}

	public void deleteProduct(int id) {
      productRepository.deleteById(id);
	}

}
