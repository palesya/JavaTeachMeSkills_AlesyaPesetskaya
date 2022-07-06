package com.tms.mybank.core.dao;

import com.tms.mybank.core.entity.User;

import java.util.Arrays;
import java.util.List;

public class UserRepository {

    private AddressRepository addressRepository = new AddressRepository();

    public User save (User user){
        addressRepository.save(user.getAddress());
        System.out.println("User is saved");
        return user;
    }

    public User update (User user){
        System.out.println("User is updated");
        return user;
    }

    public User get (String name){
        System.out.println("User get");
        return new User(name);
    }

    public List<User> getAll() {
        return Arrays.asList(new User("Alesya","pass"),
                new User("Ivan", "aaa"));
    }
}
