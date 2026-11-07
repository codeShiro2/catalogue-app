package com.codeShiro2.github.catalog.repository;

import com.codeShiro2.github.catalog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // fetch all products of a specific category
    List<Product> findByCategory(String category);
}
