package com.example.full_test.web;

import com.example.full_test.exception.UserAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserRestAdvice {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<?> process(){
        return ResponseEntity.badRequest().build();
    }
}
