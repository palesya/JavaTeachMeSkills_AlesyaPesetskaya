package com.tms.bootdatajpa.service;

import com.tms.bootdatajpa.model.User;
import com.tms.bootdatajpa.model.UserProjection;
import com.tms.bootdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
public class StartupService {

    @Autowired
    UserRepository repository;

    @PostConstruct
    public void init() {
        User user1 = User.builder()
                .login("user1")
                .password("pass")
                .isActive(false)
                .birthday(new Date())
                .build();

        User user2 = User.builder()
                .login("user2")
                .password("pass")
                .isActive(true)
                .birthday(new Date())
                .build();

        User user3 = User.builder()
                .login("user3")
                .password("pass")
                .isActive(false)
                .birthday(new Date())
                .build();

        PageRequest of = PageRequest.of(0, 2);
        PageRequest pageRequest = PageRequest.ofSize(1);
        Page<User> all = repository.findAll(pageRequest);
        System.out.println(all);

        List<UserProjection> byIsActive = repository.findByIsActive(false);
        for(UserProjection user:byIsActive){
            System.out.println(user.getLogin()+" "+user.getIsActive());
        }


//
//        repository.save(user1);
//        repository.save(user2);
//        repository.save(user3);
//
//        List<User> usersFromDB = repository.getByIsActiveIsTrue();
//        for (User user : usersFromDB) {
//            System.out.println(user);
//        }
//        System.out.println("---------------------------------");
//        List<User> alesya = repository.findMyUser("user1");
//        System.out.println(alesya);
//        System.out.println(repository.count());
//        repository.updateActive(false,1L);
    }
}
