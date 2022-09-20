package com.tms.springtoken.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class HomeController {

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("worked");
    }
}
