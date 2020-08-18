package com.prograd.saiteja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prograd.saiteja.model.Cart;
import com.prograd.saiteja.repository.CartRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CartController {

	@Autowired
	CartRepository cartRepository;

	@PostMapping("/addCart")
	public void addCart(@RequestBody Cart cartProduct) {
		if (this.getCartItem(cartProduct.getId()) == null)
			cartRepository.save(cartProduct);
		else
			{
			System.out.println("calling update method");
			this.updateCart(cartProduct);
			}
	}

	@GetMapping("/getCartItem/{id}")
	public Cart getCartItem(@PathVariable("id") int id) {
		return cartRepository.findById(id).orElse(null);
	}

	@GetMapping("/getCartItems")
	public List<Cart> getCart() {
		return cartRepository.findAll();
	}

	@PutMapping("/updateCart")
	public List<Cart> updateCart(@RequestBody Cart cartProduct) {
		Cart existingCart = cartRepository.findById(cartProduct.getId()).orElse(null);
		int c = existingCart.getCount() + cartProduct.getCount();
		int p = cartProduct.getPrice() * c;
		existingCart.setCount(c);
		existingCart.setTotalPrice(p);
		cartRepository.save(existingCart);
		return cartRepository.findAll();
	}

	@DeleteMapping("/deleteCartItem/{id}")
	public List<Cart> deleteCartItemById(@PathVariable("id") int id) {
		cartRepository.deleteById(id);
		return cartRepository.findAll();
	}

	@DeleteMapping("/deleteCart")
	public List<Cart> emptyCart() {
		cartRepository.deleteAll();
		return cartRepository.findAll();
	}

}
