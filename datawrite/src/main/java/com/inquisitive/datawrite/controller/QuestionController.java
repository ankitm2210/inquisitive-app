package com.inquisitive.datawrite.controller;

import com.inquisitive.datawrite.model.Question;
import com.inquisitive.datawrite.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by ankitmishra on 26/01/20.
 */

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;

    @PostMapping
    public ResponseEntity<Question> createQuestion(@Valid @RequestBody Question question){
        Question result = questionRepository.save(question);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Question> updateUser(@Valid @RequestBody Question question){
        Question oldQuestion = questionRepository.getOne(question.getId());
        getUpdatedQuestion(oldQuestion,question);
        Question result =questionRepository.save(question);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Question> deleteUser(@PathVariable(value = "id") Long qId){
        Question acc = questionRepository.getOne(qId);
        questionRepository.delete(acc);
        return new ResponseEntity<>(acc, HttpStatus.OK);
    }

    private void getUpdatedQuestion(Question oldQuestion, @Valid Question question) {

    }
}
