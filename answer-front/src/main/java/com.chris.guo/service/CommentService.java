package com.chris.guo.service;

import com.chris.guo.Exception.NotExistException;
import com.chris.guo.domain.Answer;
import com.chris.guo.domain.Comment;
import com.chris.guo.respository.AnswerRepository;
import com.chris.guo.respository.CommentRepository;
import com.chris.guo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository, AnswerRepository answerRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
    }
    public void createComment(Long answerId , String usename, Comment comment){
       Optional<Answer> answer= answerRepository.findById(answerId);
       if(answer.isPresent()){
           comment.setAnswer(answer.get());
           userRepository.findByName(usename);
           commentRepository.save(comment);
       }
       throw new NotExistException("this answer does not exist ");
    }
}
