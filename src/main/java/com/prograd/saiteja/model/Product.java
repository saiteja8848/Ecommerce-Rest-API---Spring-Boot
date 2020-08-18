package com.prograd.saiteja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productid", nullable = false)
	private int productId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "price", nullable = false)
	private int price;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Column(name = "imageurl", nullable = false)
	private String imageUrl;

	@Column(name = "counter", nullable = false, columnDefinition = "int default 0")
	private int counter;

	@Column(name = "clickStatus", nullable = false, columnDefinition = "boolean default false")
	private boolean clickStatus;

	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(referencedColumnName = "subCategoryId", nullable = false)
	private Subcategory subcategory;

	public Product() {
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public boolean isClickStatus() {
		return clickStatus;
	}

	public void setClickStatus(boolean clickStatus) {
		this.clickStatus = clickStatus;
	}

}
