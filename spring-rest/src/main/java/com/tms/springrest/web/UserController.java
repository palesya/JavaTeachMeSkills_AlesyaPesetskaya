package com.tms.springrest.web;

import com.tms.springrest.dto.SEX;
import com.tms.springrest.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @GetMapping("/{userId}")
    public ResponseEntity<User> get(@PathVariable("userId") Long userId) {
        User user = new User();
        user.setId(userId);
        user.setUsername("Alesya");
        user.setPassword("pass");
        user.setSex(SEX.WOMAN);
        user.setDate(new Date());
        System.out.println("get User " + user);
        return ResponseEntity.ok(user);
    }

//    @GetMapping()
//    public User getAll(){
//        return Arrays.asList(new User("asa","sdd",));
//    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        System.out.println("created user " + user);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        System.out.println("updated user " + user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable("userId") Long userId) {
        if (userId.equals(30L)) {
            return ResponseEntity
                    .status(400)
                    .build();
        } else {
            System.out.println("delete user with id " + userId);
            return ResponseEntity.ok().build();
        }
    }
}
