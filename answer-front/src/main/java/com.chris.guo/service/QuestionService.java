package com.chris.guo.service;

import com.chris.guo.domain.Question;
import com.chris.guo.domain.User;
import com.chris.guo.respository.QuestionRepository;
import com.chris.guo.respository.UserRepository;
import org.hibernate.engine.jdbc.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final int SIZE=20;
    private final String SORT="follow";

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
    public Page<Question> loadQuestion(int page){
        Sort sort =new Sort(Sort.Direction.DESC,SORT);
        Pageable pageable = new PageRequest(page,SIZE,sort);
       return questionRepository.findAll(pageable);
    }
}
