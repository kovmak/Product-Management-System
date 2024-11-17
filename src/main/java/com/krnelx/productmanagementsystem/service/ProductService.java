package com.krnelx.productmanagementsystem.service;

import com.krnelx.productmanagementsystem.model.Product;
import com.krnelx.productmanagementsystem.repository.ProductRepository;
import com.krnelx.productmanagementsystem.specification.ProductSpecification;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> findFilteredProducts(Long categoryId, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable) {
        Specification<Product> spec = Specification.where(ProductSpecification.hasCategory(categoryId))
            .and(ProductSpecification.priceBetween(minPrice, maxPrice));

        return productRepository.findAll(spec, pageable);
    }
}