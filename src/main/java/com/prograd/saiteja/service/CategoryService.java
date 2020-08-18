package com.prograd.saiteja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prograd.saiteja.model.Category;
import com.prograd.saiteja.model.Subcategory;
import com.prograd.saiteja.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public void saveCategorys(List<Category> categorys) {
		categoryRepository.saveAll(categorys);
	}

	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}

	public List<Category> getCategorys() {
		return categoryRepository.findAll();
	}

	public Category getCategoryById(int id) {
		return categoryRepository.findById(id).orElse(null);
	}

	public void updateCategory(Category category) {
		Category existingCategory = categoryRepository.findById(category.getCategoryId()).orElse(null);
		existingCategory.setCategoryName(category.getCategoryName());
		categoryRepository.save(category);
	}

	public void deleteCategoryById(int id) {
		categoryRepository.deleteById(id);
	}

}
