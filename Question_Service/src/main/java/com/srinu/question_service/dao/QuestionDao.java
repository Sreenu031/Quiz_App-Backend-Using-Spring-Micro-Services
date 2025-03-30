package com.srinu.question_service.dao;


import com.srinu.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public interface QuestionDao extends JpaRepository<Question,Integer> {

        List<Question> findByCategory(String category);

        @Query(nativeQuery = true,value = "SELECT  q.id FROM question q WHERE q.category=:category order by RANDOM() LIMIT :numQ")
        List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
