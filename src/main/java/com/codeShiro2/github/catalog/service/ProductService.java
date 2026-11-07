package com.codeShiro2.github.catalog.service;

import com.codeShiro2.github.catalog.entity.Product;
import com.codeShiro2.github.catalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product save(Product product) {
        return repo.save(product);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public List<Product> getByCategory(String category) {
        return repo.findByCategory(category);
    }
}
