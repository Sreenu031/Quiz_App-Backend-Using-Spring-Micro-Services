package com.srinu.quiz_service.service;


import com.srinu.quiz_service.dao.QuizDao;
import com.srinu.quiz_service.feign.QuizInterFace;
import com.srinu.quiz_service.model.QuestionWrapper;
import com.srinu.quiz_service.model.Quiz;
import com.srinu.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterFace quizInterFace;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions = quizInterFace.getQuestionsForQuiz(category,numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.OK);


    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds= quiz.getQuestionIds();

        ResponseEntity<List<QuestionWrapper>> questions = quizInterFace.getQuestionsFromId(questionIds);

        return  questions;
    }

    public ResponseEntity<Integer> calculateScore(Integer id, List<Response> response) {

      ResponseEntity<Integer> score =  quizInterFace.getScore(response);
      return score;

    }
}
