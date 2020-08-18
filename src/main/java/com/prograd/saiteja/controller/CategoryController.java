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

import com.prograd.saiteja.model.Category;
import com.prograd.saiteja.service.CategoryService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoryController {

	  @Autowired
	  CategoryService categoryService;
		
	  @GetMapping("/getCategorys")
	  public List<Category> getCategorys() {
		  return categoryService.getCategorys();
	  }
	  
	  @GetMapping("/getCategory/{id}")
	  public Category getCategoryById(@PathVariable("id") int id) {
		  return categoryService.getCategoryById(id);
	  }
	  
	  @PostMapping("/addCategory")
	  public String  addCategory(@RequestBody Category category) {
		  categoryService.saveCategory(category);
          return "category added";
	  }
	  
	  @PutMapping("/updateCategory")
	  public String updateCategory(@RequestBody Category category) {
		  categoryService.saveCategory(category);
		  return "category updated";
	  }
	  
	  @DeleteMapping("/deleteCategory/{id}")
	  public String deleteCategoryById(@PathVariable("id") int id) {
		  categoryService.deleteCategoryById(id);
		  return "Category deleted";
	  }
		
	
}
