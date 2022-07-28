package com.tms.web;


import com.tms.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/user")
public class UserController {

//    @Autowired
//    UserLoginService service;

    @GetMapping
    public String home() {
        return "user";
    }

    @PostMapping
    public String login(@Valid User user, BindingResult result, Model model) {
        return "user";
    }

//    @ExceptionHandler(FirstException.class)
//    public String processException(FirstException exc,Model model){
//        model.addAttribute("user", new User());
//        model.addAttribute("error", exc.getMessage());
//        return "user";
//    }
//
//    @ExceptionHandler(SecondException.class)
//    public String processException(SecondException exc, Model model){
//        model.addAttribute("user", new User());
//        model.addAttribute("error", exc.getMessage());
//        return "user";
//    }
}
