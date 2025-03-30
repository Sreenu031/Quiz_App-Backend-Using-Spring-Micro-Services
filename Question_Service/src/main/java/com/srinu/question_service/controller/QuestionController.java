package com.srinu.question_service.controller;


import com.srinu.question_service.model.Question;
import com.srinu.question_service.model.QuestionWrapper;
import com.srinu.question_service.model.Response;
import com.srinu.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;



    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> allQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){

        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }

    //geneate quesitons based category and numQuesitons
//    getQuesiotns based on Listof Integers Ids
//    Find the score of quiz based on the response class

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,@RequestParam Integer numQuestions){

        return questionService.getQuestionsForQuiz(category,numQuestions);
    }

    @PostMapping("getQuestions")

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questonIds){
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromId(questonIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }
}
