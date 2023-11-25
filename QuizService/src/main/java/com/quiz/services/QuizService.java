package com.quiz.services;

import com.quiz.entities.Quiz;

import java.util.List;

public interface QuizService {
    Quiz addQuiz(Quiz newQuiz);
    List<Quiz> getAllQuizzes();
    Quiz getSingleQuiz(Long id);

}
