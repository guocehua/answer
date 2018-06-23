package com.chris.guo.controller;

import com.chris.guo.domain.Question;
import com.chris.guo.service.QuestionService;
import com.chris.guo.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
