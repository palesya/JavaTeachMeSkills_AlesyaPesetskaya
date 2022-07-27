package com.tms.web;


import com.tms.model.User;
import com.tms.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/login")
public class LoginController {

    @Autowired
    UserLoginService service;

    @GetMapping
    public String login(Model model){
        service.login(new User("guest","aaa"));
        model.addAttribute("user",new User());
        return "user";
    }
}
