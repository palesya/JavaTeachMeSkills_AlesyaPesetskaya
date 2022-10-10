package com.example.full_test.client;

import com.example.full_test.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user",url = "http://127.0.0.1:8099", path = "/user")
public interface UserClient {

    @GetMapping
    UserDto get();

}
