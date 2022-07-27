package com.tms.service;

import com.tms.exception.FirstException;
import com.tms.exception.SecondException;
import com.tms.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    public void login(User user){
        if(user.getLogin().equals("guest")){
            throw new FirstException("User guest can login");
        }else if(user.getLogin().equals("test")){
            throw new SecondException("Blocked");
        }
    }
}
