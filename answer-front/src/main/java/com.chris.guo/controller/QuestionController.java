package com.chris.guo.controller;

import com.chris.guo.domain.Question;
import com.chris.guo.service.QuestionService;
import com.chris.guo.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
@RequestMapping("/front/question")
@Controller
public class QuestionController {
    private final QuestionService questionService;
    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping("/create")
    public String createQuestion(@RequestBody Question question, HttpSession session){
        String username=SessionUtil.getUser(session);
        questionService.createQuestion(question,username);
        return "success";
    }
    @GetMapping("/first")
    public Page<Question> loadQuestion(){
       return questionService.loadQuestion(1);
    }
    @GetMapping("/next/{page}")
    public Page<Question> loadPage(@PathVariable Integer page ,HttpSession session){
        SessionUtil.getUser(session);
        return questionService.loadQuestion(page);
    }
}
