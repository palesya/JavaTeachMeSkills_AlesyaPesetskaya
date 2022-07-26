package com.tms.web;


import com.tms.model.User;
import com.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ModelAndView saveUser(
            @RequestParam("name") String name,
            @RequestParam("password") String password,
            ModelAndView modelAndView
    ) {
        userService.add(new User(name, password));
        modelAndView.setViewName("user");
        return modelAndView;
    }
}
