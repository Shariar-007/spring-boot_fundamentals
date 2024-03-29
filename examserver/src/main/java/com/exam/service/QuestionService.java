package com.exam.service;

import com.exam.models.exam.Question;
import com.exam.models.exam.Quiz;

import java.util.Set;

public interface QuestionService {

    public Question addQuestions(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(Long questionId);

    public Question get(Long questionId);
}
