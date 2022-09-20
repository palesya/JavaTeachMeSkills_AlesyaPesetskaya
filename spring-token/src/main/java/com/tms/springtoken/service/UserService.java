package com.tms.springtoken.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDetails getByUsername(String username){
        if(username != null && username.equals("Joe")){
            UserDetails user = User.builder().username(username)
                    .password("password")
                    .authorities("read")
                    .build();
            return user;
        }else{
            return null;
        }
    }
}
