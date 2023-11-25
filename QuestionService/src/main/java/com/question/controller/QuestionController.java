package com.question.controller;

import com.question.entities.Question;
import com.question.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {

         return new ResponseEntity<Question>(this.questionService.createQuestion(question), HttpStatus.CREATED);
    }
    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getSingleQuestion(@PathVariable Long questionId) {

        return new ResponseEntity<Question>(this.questionService.getSingleQuestion(questionId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestion() {

        return new ResponseEntity<List<Question>>(this.questionService.getAllQuestions(),HttpStatus.OK);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Question>> getAllQuestionsOfQuiz(@PathVariable Long quizId) {

        return new ResponseEntity<List<Question>>(this.questionService.getAllQuestionsOfAQuiz(quizId),HttpStatus.OK);
    }




}







