package com.example.spring_boot_docker.web;

import com.example.spring_boot_docker.model.User;
import com.example.spring_boot_docker.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final UserService service;

    @GetMapping
    public String home(){
        List<User> all = service.getAll();
        String collect = all.stream()
                .map(User::getLogin)
                .collect(Collectors.joining(","));
        return "Hello World! All users from db: "+ collect;
    }

    @GetMapping("/add")
    public String add(){
        String username = UUID.randomUUID().toString();
        service.save(new User(username));
        return username;
    }

}
