package com.tms.springboot.controller;

import com.tms.springboot.service.FileCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private FileCreationService service;

    @Bean
    public void addCounterToFile() throws IOException {
            service.addCounter();
    }

}
