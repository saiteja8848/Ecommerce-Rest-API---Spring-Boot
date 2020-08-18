package com.prograd.saiteja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prograd.saiteja.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
