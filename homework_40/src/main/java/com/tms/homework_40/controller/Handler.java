package com.tms.homework_40.controller;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class Handler extends Throwable{

    @ExceptionHandler({EntityNotFoundException.class, EmptyResultDataAccessException.class})
    public ResponseEntity<Object> handle(Exception ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

}