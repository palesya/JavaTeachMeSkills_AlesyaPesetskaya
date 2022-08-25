package com.tms.springboot.service;

import com.tms.springboot.model.User;
import com.tms.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class StartupService {

    private final UserRepository repository;

    @PostConstruct
    public void init(){
        User user = User.builder()
                .login("username")
                .password("password")
                .isActive(true)
                .birthday(new Date())
                .build();

        repository.save(user);
    }
}
