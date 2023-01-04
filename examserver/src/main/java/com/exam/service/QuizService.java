package com.exam.service;

import com.exam.models.exam.Category;
import com.exam.models.exam.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public Quiz getQuiz(Long quizId);

    public List<Quiz> getQuizByCategory(Category category);

    public List<Quiz> getActiveQuizzes(Boolean b);

    public List<Quiz> getActiveQuizzesOfCategory(Category category, Boolean b);

    public void deleteQuiz(Quiz quiz);
}
