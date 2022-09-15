package com.tms.springsecurity.web;

import com.tms.springsecurity.service.SecuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    SecuredService securedService;

    @GetMapping(path="/read")
    public String read(){
        return "read.html";
    }

    @GetMapping(path="/write")
    public String write(){
        return "write.html";
    }

    @GetMapping(path="/user")
    public String user(){
        return "user.html";
    }

    @GetMapping(path="/admin")
    public String admin(){
        return "admin.html";
    }

    //@Secured("ROLE_ADMIN")
    @GetMapping(path="/test")
    public String test(){
        System.out.println("hello");
        securedService.secured();
        return "test.html";
    }

}
