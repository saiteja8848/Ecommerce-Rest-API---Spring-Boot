package com.prograd.saiteja.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Subcategory {

	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(referencedColumnName = "categoryId", nullable = false)
	private Category category;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subCategoryId;
	
	@Column(nullable=false)
	private String subCategoryName;
	
	@OneToMany(mappedBy="subcategory",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Product> products = new ArrayList<>();
	
	public Subcategory() {
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
   
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

}
