package com.tms.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;


@Component
@Scope(scopeName = "prototype")
public class DataBase {

    public DataBase() {
        System.out.println("constructor");
    }

    @PostConstruct
    public void init(){
        System.out.println("init db");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy db");
    }

    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        boolean alreadyExist = users.stream()
                .anyMatch(us -> us.getUsername().equals(user.getUsername()));
        if(alreadyExist){
            System.out.printf("User with name %s already exists\n", user.getUsername());
            throw new IllegalArgumentException();
        }
        users.add(user);
        System.out.printf("User %s was added to database\n", user.getUsername());
    }

    public List<User> getUsers(){
        return users;
    }

}
