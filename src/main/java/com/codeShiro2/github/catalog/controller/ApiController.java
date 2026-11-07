package com.codeShiro2.github.catalog.controller;

import com.codeShiro2.github.catalog.entity.Feedback;
import com.codeShiro2.github.catalog.entity.Product;
import com.codeShiro2.github.catalog.service.FeedbackService;
import com.codeShiro2.github.catalog.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ProductService productService;
    private final FeedbackService feedbackService;

    public ApiController(ProductService productService, FeedbackService feedbackService) {
        this.productService = productService;
        this.feedbackService = feedbackService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(required = false) String category) {
        if (category != null && !category.isBlank()) {
            return productService.getByCategory(category.trim());
        }
        return productService.getAll();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/feedback")
    public List<Feedback> getFeedback() {
        return feedbackService.getAll();
    }

    @PostMapping("/feedback")
    public String saveFeedback(@RequestBody Feedback feedback) {
        feedbackService.save(feedback);
        return "feedback saved!";
    }
}