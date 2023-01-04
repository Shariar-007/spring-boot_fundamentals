package com.exam.repo;

import com.exam.models.exam.Category;
import com.exam.models.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByCategory(Category category);

    List<Quiz> findByActive(Boolean t);

    List<Quiz> findByCategoryAndActive(Category category, Boolean t);
}
