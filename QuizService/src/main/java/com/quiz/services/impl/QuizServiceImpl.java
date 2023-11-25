package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;
    //no need for @Autowired since only one constructor


    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz addQuiz(Quiz newQuiz) {
        return this.quizRepository.save(newQuiz);
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        List<Quiz> allQuizzes = this.quizRepository.findAll();
        allQuizzes.stream().map(quiz -> {
            quiz.setQuestions(this.questionClient.getQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).toList();
        return allQuizzes;
    }

    @Override
    public Quiz getSingleQuiz(Long id) {
        Quiz quiz=this.quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz not found"));
        quiz.setQuestions(this.questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;


    }
}
