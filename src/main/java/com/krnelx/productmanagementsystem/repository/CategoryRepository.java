package com.krnelx.productmanagementsystem.repository;

import com.krnelx.productmanagementsystem.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}