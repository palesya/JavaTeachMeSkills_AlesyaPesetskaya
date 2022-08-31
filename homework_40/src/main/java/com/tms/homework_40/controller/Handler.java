package com.tms.homework_40.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler extends Throwable{

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

}