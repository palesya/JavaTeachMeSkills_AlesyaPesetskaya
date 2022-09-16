package com.tms.homework_45.service;

import com.tms.homework_45.model.Role;
import com.tms.homework_45.model.User;
import com.tms.homework_45.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StartupService {

    @Autowired
    UserRepository repository;

    @PostConstruct
    public void init() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        User userAdmin=new User("Alesya","$2a$12$7yZWYbn053qe9oqzWGIMLufEQDOK1IDrwDBTAO1Z4pqvetiKJro1m", List.of(roleAdmin));
        User userUser=new User("Pavel","$2a$12$0MVFjJpjhqvZ9.RPa8zDf.cxsg3lQcnEy36f1jClT5Sy07UV5GYxq", List.of(roleUser));
        List<User> allUsers = Arrays.asList(userAdmin,userUser);
        List<String> allUserNames = repository.findAll().stream().map(User::getName).collect(Collectors.toList());
        for(User user:allUsers){
            if(!allUserNames.contains(user.getName())){
                repository.save(user);
            }
        }
    }
}
