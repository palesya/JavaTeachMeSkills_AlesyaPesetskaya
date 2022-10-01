package com.hmw.homework_46.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("home")
    public ResponseEntity<String> getHome() {
        return ResponseEntity.ok("It is home. And you are authorized.");
    }

    @GetMapping("all")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("It is available for all users.");
    }

    @GetMapping("authorized")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> getAuth() {
        return ResponseEntity.ok("It is available for only authorized users.");
    }
}
