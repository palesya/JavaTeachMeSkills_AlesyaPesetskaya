package com.tms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/user")
public class HomeController {

    @GetMapping
    public String get() {
        System.out.println("------------GET HOME-----------------");
        return "user";
    }

    @PostMapping()
    public String save(@RequestParam(name = "login") String username,
                       @RequestParam(name = "password") String password,
                       @RequestHeader("User-Agent") String header) {
        System.out.println("------------POST HOME-----------------");
        return "user";
    }
}
