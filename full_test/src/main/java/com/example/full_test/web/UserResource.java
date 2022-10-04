package com.example.full_test.web;

import com.example.full_test.model.User;
import com.example.full_test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService service;

    public List<User> getAll(){
        return service.getAll();
    }

}
