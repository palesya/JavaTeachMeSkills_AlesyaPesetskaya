package com.tms.springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@RequestMapping(path = "/")
public class HomeController {

    @GetMapping
    public String home(){
        System.out.println();
        return "home";
    }
}
