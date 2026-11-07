package com.codeShiro2.github.catalog.controller;

import com.codeShiro2.github.catalog.entity.Product;
import com.codeShiro2.github.catalog.service.FeedbackService;
import com.codeShiro2.github.catalog.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductService productService;
    private final FeedbackService feedbackService;

    public ProductController(ProductService productService, FeedbackService feedbackService) {
        this.productService = productService;
        this.feedbackService = feedbackService;
    }

    // Home: two options
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Product form
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/display";
    }

    // Product table (optional ?category=xyz filter) + feedback list below it
    @GetMapping("/display")
    public String display(@RequestParam(required = false) String category, Model model) {
        if (category != null && !category.isBlank()) {
            model.addAttribute("products", productService.getByCategory(category.trim()));
            model.addAttribute("category", category.trim());
        } else {
            model.addAttribute("products", productService.getAll());
        }
        model.addAttribute("feedbacks", feedbackService.getAll());
        return "display";
    }
}
