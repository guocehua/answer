package com.chris.guo.controller;

import com.chris.guo.domain.Answer;
import com.chris.guo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
@RequestMapping("/front/answer")
@Controller
public class AnswerController {
    private final AnswerService answerService;
    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }
    @PostMapping("/create")
    public String createAnswer(Answer answer , HttpSession session){
        return null;
    }
}
