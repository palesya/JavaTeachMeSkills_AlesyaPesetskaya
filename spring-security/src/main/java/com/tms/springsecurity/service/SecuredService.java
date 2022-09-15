package com.tms.springsecurity.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class SecuredService {

    @Secured("ROLE_ADMIN")
    public String secured(){
        System.out.println("we are here");
        return "test";
    }
}
