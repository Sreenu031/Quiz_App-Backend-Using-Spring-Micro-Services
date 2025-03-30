package com.srinu.question_service.service;


import com.srinu.question_service.dao.QuestionDao;
import com.srinu.question_service.model.Question;
import com.srinu.question_service.model.QuestionWrapper;
import com.srinu.question_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
     return    questionDao.findAll();

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {

        return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, Integer numQuestions) {
        List<Integer> quesions = questionDao.findRandomQuestionsByCategory(category,numQuestions);
        return new ResponseEntity<>(quesions,HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questonIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for(var id:questonIds){
            questions.add(questionDao.findById(id).get());
        }

        for(var question:questions){
            QuestionWrapper questionWrapper = new QuestionWrapper();
            questionWrapper.setId(question.getId());
            questionWrapper.setQuestionTitle(question.getQuestionTitle());
            questionWrapper.setOption1(question.getOption1());
            questionWrapper.setOption2(question.getOption2());
            questionWrapper.setOption3(question.getOption3());
            questionWrapper.setOption4(question.getOption4());

            wrappers.add(questionWrapper);
        }

        return new ResponseEntity<>(wrappers,HttpStatus.OK);

    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {



        Integer score=0;

        for(var res:responses){
            Question question = questionDao.findById(res.getId()).get();
            if(res.getResponse().equals(question.getRightAnswer()))
                score++;


        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
