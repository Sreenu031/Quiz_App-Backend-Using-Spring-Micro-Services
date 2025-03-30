package com.srinu.quiz_service.controller;


import com.srinu.quiz_service.model.QuestionWrapper;
import com.srinu.quiz_service.model.QuizDto;
import com.srinu.quiz_service.model.Response;
import com.srinu.quiz_service.service.QuizService;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuize(@RequestBody QuizDto quizDto){


        return  quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return  quizService.getQuizQuestions(id);

    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submit(@PathVariable Integer id,@RequestBody List<Response> response){
        return quizService.calculateScore(id,response);
    }


}
