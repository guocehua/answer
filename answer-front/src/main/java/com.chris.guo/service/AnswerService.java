package com.chris.guo.service;

import com.chris.guo.Exception.NotExistException;
import com.chris.guo.domain.Answer;
import com.chris.guo.domain.Question;
import com.chris.guo.respository.AnswerRepository;
import com.chris.guo.respository.QuestionRepository;
import com.chris.guo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository, UserRepository userRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    public void createAnswer(Long questionId, Answer answer, String username) {
        Optional<Question> question = questionRepository.findById(questionId);
        if (question.isPresent()) {
            userRepository.findByName(username);
            answer.setQuestion(question.get());
            answerRepository.save(answer);
        }
        throw new NotExistException("The question does not exist");
    }
}
