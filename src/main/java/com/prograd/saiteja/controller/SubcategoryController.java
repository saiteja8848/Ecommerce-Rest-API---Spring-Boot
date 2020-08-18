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

import com.prograd.saiteja.model.Category;
import com.prograd.saiteja.model.Subcategory;
import com.prograd.saiteja.repository.CategoryRepository;
import com.prograd.saiteja.service.SubcategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SubcategoryController {

	@Autowired
	SubcategoryService subcategoryService;

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/getSubcategorys")
	public List<Subcategory> getSubcategorys() {
		return subcategoryService.getSubcategorys();
	}

	@GetMapping("/getSubcategory/{id}")
	public Subcategory getSubcategoryById(@PathVariable("id") int id) {
		return subcategoryService.getSubcategoryById(id);
	}

	@PutMapping("/updateSubcategory")
	public String updateSubcategory(@RequestBody Subcategory subcategory) {
		subcategoryService.saveSubcategory(subcategory);
		return "subcategory updated";
	}

	@PostMapping("/addSubcategory/{categoryId}")
	public String addSubcategory(@RequestBody Subcategory subcategory, @PathVariable("categoryId") int categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		if (category.isPresent()) {
			subcategory.setCategory(category.get());
			subcategoryService.saveSubcategory(subcategory);
			return "Subcategory added";
		} else
			return "Category Not Found,So Subcategory Cannot be Added";
	}

	@DeleteMapping("/deleteSubcategory/{subcategoryId}")
	public String deleteSubcategory(@PathVariable("subcategoryId") int subcategoryId) {
		subcategoryService.deleteSubcategoryById(subcategoryId);
		return "Subcategory deleted";
	}

}
