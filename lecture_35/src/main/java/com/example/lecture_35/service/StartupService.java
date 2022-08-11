package com.example.lecture_35.service;


import com.example.lecture_35.model.Address;
import com.example.lecture_35.model.User;
import com.example.lecture_35.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.Date;

import static com.example.lecture_35.model.SEX.MAN;
import static com.example.lecture_35.model.SEX.WOMAN;

@Service
public class StartupService {

    @Autowired
    private UserRepositoryImpl repository;

    @PostConstruct
    public void init(){
        User user = new User("user_login","user_password",WOMAN);
        user.setAddress(new Address("Minsk",1));
        user.setDate(new Date());
        User user1 = new User("user_login1","user_password1",MAN);
        user1.setAddress(new Address("Vitebsk",23));
        user1.setDate(new Date());
        repository.save(user);
        repository.save(user1);
        repository.updateName(1,"new_name");
        User user2 = repository.getById(1);
        System.out.println(user2);
    }
}
