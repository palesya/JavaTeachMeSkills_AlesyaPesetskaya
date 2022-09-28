package com.template;

public abstract class UserService {

    void saveUser(User user){
        System.out.println("get info about user");
        System.out.println("check user exists");
        if(isValidUser(user)){
            System.out.println("user is saved");
        }
        System.out.println("end");
    }

    protected abstract boolean isValidUser(User user);

}
