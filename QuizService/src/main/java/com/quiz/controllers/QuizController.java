package com.quiz.controllers;


import com.quiz.entities.Quiz;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    private QuestionClient questionClient;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz)
    {
        return new ResponseEntity<Quiz>(this.quizService.addQuiz(quiz), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes()
    {
        return new ResponseEntity<List<Quiz>>(this.quizService.getAllQuizzes(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Quiz> getSingleQuiz(@PathVariable Long id)
    {
        return new ResponseEntity<Quiz>(this.quizService.getSingleQuiz(id),HttpStatus.OK) ;

    }
}
