package com.prograd.saiteja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prograd.saiteja.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
