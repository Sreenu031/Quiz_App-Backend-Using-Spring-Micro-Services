package com.srinu.question_service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;

    @Version
    private Integer version;
}


//insert into question values(5,'Easy','def','function','fun','block','In Python how to define function?','def','python')
//insert into question values(4,'Easy','Static binding occurs during Compile time.','Static binding occurs during load time.','Static binding occurs during runtime.','None of the above.',' When static binding occurs?','Static binding occurs during Compile time.','Java')
