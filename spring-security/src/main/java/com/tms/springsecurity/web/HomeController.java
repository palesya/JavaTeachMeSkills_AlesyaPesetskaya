package com.tms.springsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(path="/user")
    public String user(){
        return "user.html";
    }

    @GetMapping(path="/admin")
    public String admin(){
        return "admin.html";
    }

}
