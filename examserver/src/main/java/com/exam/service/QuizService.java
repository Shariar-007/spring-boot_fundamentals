package com.exam.service;

import com.exam.models.exam.Quiz;

import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz category);

    public Quiz updateQuiz(Quiz category);

    public Set<Quiz> getQuizzes();

    public Quiz getQuiz(Long quizId);

    public void deleteQuiz(Long quizId);
}
