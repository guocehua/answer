package com.chris.guo.service;

import com.chris.guo.domain.User;
import com.chris.guo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SystemService {
    private final UserRepository userRepository;

    @Autowired
    public SystemService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean  identify(String username,String password){
        User user=userRepository.findByName(username);
        if(user!=null){
           if(Objects.equals(password,user.getPassword()))
               return true;
        }
        return false;
    }
    public String Register(User user) {
        if(user.getName()!=null){
            if(userRepository.findByName(user.getName())!=null){
             return "username existed";
            }

        }
        userRepository.save(user);
        return "success";
    }

}
