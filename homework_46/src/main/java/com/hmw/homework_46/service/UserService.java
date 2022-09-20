package com.hmw.homework_46.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDetails getByUsername(String username){
        if(username != null && username.equals("Alesya")){
            return User.builder()
                    .username(username)
                    .password("password")
                    .authorities("read")
                    .build();
        }else{
            return null;
        }
    }
}
