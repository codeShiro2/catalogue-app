package com.codeShiro2.github.catalog.controller;

import com.codeShiro2.github.catalog.entity.Feedback;
import com.codeShiro2.github.catalog.service.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    // display feedback form
    @GetMapping("/feedback")
    public String form() {
        return "feedback";
    }

    // handle form submission and save data
    @PostMapping("/saveFeedback")
    public String save(@ModelAttribute("feedbackForm") Feedback feedback) {
        service.save(feedback);
        return "feedback-saved";
    }
}
