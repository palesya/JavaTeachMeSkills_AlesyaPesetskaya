package com.example.lecture_35.service;


import com.example.lecture_35.model.Address;
import com.example.lecture_35.model.Pet;
import com.example.lecture_35.model.Phone;
import com.example.lecture_35.model.User;
import com.example.lecture_35.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.lecture_35.model.SEX.MAN;
import static com.example.lecture_35.model.SEX.WOMAN;

@Service
public class StartupService {

    @Autowired
    private UserRepositoryImpl repository;

    @PostConstruct
    public void init() {
        User user = new User("user_login", "user_password", WOMAN);
        user.setId(2);
        user.setDate(new Date());
        User user1 = new User("user_login1", "user_password1", MAN);
        Address address1 = new Address("Minsk2", 1);
        Address address2 = new Address("Vitebsk2", 23);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);
        user1.setAddress(addresses);
        Phone phone = new Phone("123456");
        Pet cat = new Pet("cat", "Murca");
        Pet dog = new Pet("dog", "Charly");
        List<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);
        user1.setPhone(phone);
        user1.setDate(new Date());
        user1.setPets(pets);
        user.setPhone(phone);
        user.setDate(new Date());
        user.setPets(pets);
        repository.save(user1);
        //repository.save(user);
        System.out.println("--------------");
        System.out.println(user1.getAddress().get(0).getCity());
        System.out.println("--------------");
    }
}
