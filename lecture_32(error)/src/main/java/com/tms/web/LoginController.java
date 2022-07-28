package com.tms.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/login")
public class LoginController {

//    @Autowired
//    UserLoginService service;
//
//    @GetMapping
//    public String login(Model model){
//        service.login(new User("guest","aaa"));
//        model.addAttribute("user",new User());
//        return "user";
//    }
}
