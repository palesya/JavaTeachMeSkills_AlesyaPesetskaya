package com.tms;

import com.tms.dto.User;

import java.util.ArrayList;
import java.util.List;


public class UserDBStore {

    private List<User> users = new ArrayList<>();

    private static UserDBStore instance = null;

    private UserDBStore(){

    }

    public static UserDBStore getInstance(){
        if(instance==null){
            instance = new UserDBStore();
        }
        return instance;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void deleteUser(User user){
        users.remove(user);
    }

    public List<User> getAll(){
        return users;
    }

}
