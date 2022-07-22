package com.tms;

import com.tms.lecture_26.User;

import java.util.HashMap;
import java.util.Map;

public class UserDBStore {

    private static Map<String, User> users = new HashMap<>();

    public User getByLogin(String login){
        return users.getOrDefault(login,null);
    }

    public void save(User user){
       users.put(user.getLogin(),user);
    }

}
