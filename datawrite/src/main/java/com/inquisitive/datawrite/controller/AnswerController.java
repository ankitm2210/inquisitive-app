package com.inquisitive.datawrite.controller;

import com.inquisitive.datawrite.model.Answer;
import com.inquisitive.datawrite.model.Question;
import com.inquisitive.datawrite.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by ankitmishra on 27/01/20.
 */
@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    AnswerRepository answerRepository;

    @PostMapping
    public ResponseEntity<Answer> createQuestion(@Valid @RequestBody Answer answer){
        Answer result = answerRepository.save(answer);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Answer> updateUser(@Valid @RequestBody Answer answer){
        Answer oldAnswer = answerRepository.getOne(answer.getId());
        getUpdatedQuestion(oldAnswer,answer);
        Answer result = answerRepository.save(answer);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Answer> deleteUser(@PathVariable(value = "id") Long aId){
        Answer acc = answerRepository.getOne(aId);
        answerRepository.delete(acc);
        return new ResponseEntity<>(acc, HttpStatus.OK);
    }

    private void getUpdatedQuestion(Answer oldAnswer, @Valid Answer answer) {

    }
}
