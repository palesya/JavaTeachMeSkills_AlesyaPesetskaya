package com.lecture_43.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getVersion(){
        return "0.1.2";
    }
}
