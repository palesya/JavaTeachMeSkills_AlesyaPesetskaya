package com.tms.homework_40.controller;


import com.tms.homework_40.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler{

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDTO> handle(Exception ex) {
        return ResponseEntity.status(400).body(new ErrorDTO("Error from dto: "+ex.getMessage()));
    }

}