package com.prograd.saiteja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prograd.saiteja.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
