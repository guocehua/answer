package com.chris.guo.service;

import com.chris.guo.domain.Question;
import com.chris.guo.domain.User;
import com.chris.guo.respository.QuestionRepository;
import com.chris.guo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    public void createQuestion(Question question, String username){
        User user= userRepository.findByName(username);
        question.setUser(user);
        questionRepository.save(question);
    }
}
