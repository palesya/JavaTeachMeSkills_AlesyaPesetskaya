package com.lecture_43.web;

import com.lecture_43.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/")
public class UserController {

    @GetMapping
    public ModelAndView getHomePage(){
        ModelAndView modelAndView = new ModelAndView("user.html");
        User user1 = new User("Alesya",33,true);
        modelAndView.addObject("person",user1);
        Map<String, User> maps = new HashMap<>();
        User user2 =new User("Vasya",30, false);
        maps.put("user",user2);
        modelAndView.addObject("attribute",maps);
        User user3 =new User("Ivan",20, true);
        User user4 =new User("Petya",35, false);
        List<User> users = List.of(user1,user2,user3,user4);
        modelAndView.addObject("users",users);
        return modelAndView;
    }
}
