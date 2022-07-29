package com.tms.web;


import com.tms.model.Book;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler
    public String processException(Exception ex, Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("error",ex.getMessage());
        return "book";
    }

}
