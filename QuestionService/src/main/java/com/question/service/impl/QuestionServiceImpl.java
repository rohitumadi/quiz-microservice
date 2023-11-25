package com.question.service.impl;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import com.question.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question createQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question getSingleQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).orElseThrow(()->new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getAllQuestionsOfAQuiz(Long quizId) {
        return this.questionRepository.findByQuizId(quizId);
    }
}
