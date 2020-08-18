package com.prograd.saiteja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prograd.saiteja.model.Subcategory;
import com.prograd.saiteja.repository.SubcategoryRepository;

@Service
public class SubcategoryService {

	@Autowired
     SubcategoryRepository subcategoryRepository;

	public void saveSubcategorys(List<Subcategory> subcategorys) {
		subcategoryRepository.saveAll(subcategorys);
	}

	public void saveSubcategory(Subcategory subcategory) {
		subcategoryRepository.save(subcategory);
	}

	public List<Subcategory> getSubcategorys() {
		return subcategoryRepository.findAll();
	}

	public Subcategory getSubcategoryById(int id) {
		return subcategoryRepository.findById(id).orElse(null);
	}

	public void updateSubcategory(Subcategory subcategory) {
	  Subcategory existingSubcategory = subcategoryRepository.findById(subcategory.getSubCategoryId()).orElse(null);
		existingSubcategory.setSubCategoryName(subcategory.getSubCategoryName());
		subcategoryRepository.save(subcategory);
	}

	public void deleteSubcategoryById(int id) {
       subcategoryRepository.deleteById(id);
	}
	
}
