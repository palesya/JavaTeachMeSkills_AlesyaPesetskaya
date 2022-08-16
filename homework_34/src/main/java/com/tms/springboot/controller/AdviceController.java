package com.tms.springboot.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(IOException.class)
    public void handleIOException(Exception ex){
        System.out.println(ex.getMessage());
    }

}
