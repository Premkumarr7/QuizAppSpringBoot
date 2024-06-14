package com.jprem.quizapp.controller;

import com.jprem.quizapp.model.Question;
import com.jprem.quizapp.model.QuestionWrapper;
import com.jprem.quizapp.model.Response;
import com.jprem.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String > createQuiz(@RequestParam String category, @RequestParam int numQ,@RequestParam String title){
//        return new ResponseEntity<>("im Here",HttpStatus.OK);
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable Integer id){
        return quizService.getQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response){
        return quizService.submitQuiz(id,response);
    }
}
