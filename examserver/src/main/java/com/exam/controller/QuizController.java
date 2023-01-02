package com.exam.controller;

import com.exam.models.exam.Category;
import com.exam.models.exam.Quiz;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz) {
        Quiz quiz1 = this.quizService.addQuiz(quiz);
        return ResponseEntity.ok(quiz1);
    }

    @PutMapping
    public Quiz updateQuiz(@RequestBody Quiz quiz) {
        return this.quizService.updateQuiz(quiz);
    }

    @GetMapping
    public ResponseEntity<?> getQuizzes() {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    @GetMapping("/{quizId}")
    public Quiz getQuizById(@PathVariable("quizId") Long id) {
        return this.quizService.getQuiz(id);
    }

    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long id) {
        Quiz quiz = new Quiz();
        quiz.setQId(id);
        this.quizService.deleteQuiz(quiz);
    }

}
