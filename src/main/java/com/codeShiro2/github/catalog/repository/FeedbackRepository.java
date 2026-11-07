package com.codeShiro2.github.catalog.repository;

import com.codeShiro2.github.catalog.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
