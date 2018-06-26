package com.chris.guo.controller;

import com.chris.guo.domain.Comment;
import com.chris.guo.service.CommentService;
import com.chris.guo.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/comment")
@Controller
public class CommentController {
    private final CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping("/create/{answer_id}")
    public String createComment(@PathVariable Long answerId , @RequestBody Comment comment , HttpSession session){
        String username=SessionUtil.getUser(session);
        commentService.createComment(answerId,username,comment);
        return "success";
    }
}
