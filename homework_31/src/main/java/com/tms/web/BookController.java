package com.tms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @GetMapping
    public String get() {
        return "book";
    }

    @PostMapping
    public String searchBook(){
        return "book";
    }

}
