package com.chris.guo.controller;

import com.chris.guo.domain.Login;
import com.chris.guo.domain.User;
import com.chris.guo.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/sys")
public class SystemController {
    private final SystemService systemService;

    @Autowired
    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }
    @PostMapping("/login")
    public String login(@RequestBody Login login, HttpSession session){
        boolean log=systemService.identify(login.getUsername(),login.getPassword());
        if(log){
            session.setAttribute("username",login.getUsername());
            return "success";
        }
        return "failed";
    }
    @PostMapping("/register")
    public String register(@RequestBody User user){
        return systemService.Register(user);
    }
}
