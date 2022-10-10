package com.example.full_test.web;

import com.example.full_test.client.UserClient;
import com.example.full_test.dto.UserDto;
import com.example.full_test.model.User;
import com.example.full_test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService service;
    private final UserClient client;

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable(name = "id") String id) {
        Long aLong = Long.valueOf(id);
        UserDto userFromDB = service.getById(aLong);
        if (userFromDB != null) {
            return ResponseEntity.ok(userFromDB);
        } else
            return ResponseEntity.status(400).build();
    }

    @PostMapping
    public UserDto userSave(@RequestBody UserDto user) {
        UserDto save = service.save(user);
        return save;
    }

    @PostMapping(path="/test")
    public UserDto testFeign(@RequestBody UserDto user){
        UserDto userDto = client.get();
        return userDto;
    }

}
