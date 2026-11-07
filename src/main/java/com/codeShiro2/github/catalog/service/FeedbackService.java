package com.codeShiro2.github.catalog.service;

import com.codeShiro2.github.catalog.entity.Feedback;
import com.codeShiro2.github.catalog.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository repo;

    public FeedbackService(FeedbackRepository repo) {
        this.repo = repo;
    }

    public Feedback save(Feedback feedback) {
        return repo.save(feedback);
    }

    public List<Feedback> getAll() {
        return repo.findAll();
    }
}
