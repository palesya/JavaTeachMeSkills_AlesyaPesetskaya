package com.tms.springrest.web;

import com.tms.springrest.dto.ErrorDTO;
import com.tms.springrest.dto.SEX;
import com.tms.springrest.dto.User;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/api/user")
@Tag(name = "My home controller", description = "This controller is used for user's CRUD operations.")
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

    @GetMapping()
    @Tag(name = "get All", description = "Get all users")
    public ResponseEntity<List<User>> getAll() {
        User user1 = new User(20L, "name", "pass", SEX.MAN, new Date());
        User user2 = new User(21L, "name21", "pass21", SEX.WOMAN, new Date());
        Link link1 = linkTo(methodOn(UserController.class).get(20L)).withSelfRel();
        Link link2 = linkTo(methodOn(UserController.class).get(21L)).withSelfRel();
        user1.add(link1);
        user2.add(link2);
        return ResponseEntity.ok(Arrays.asList(user1, user2));
    }

    @PostMapping
    @Tag(name = "POST for user",
            description = "Saves information about new User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success operation", headers = {
                    @Header(name = "My header", required = true, description = "just for test")},
                    content = {
                            @Content(schema = @Schema(implementation = User.class))
                    }),
            @ApiResponse(responseCode = "400", description = "something broken",
                    content = {
                            @Content(schema = @Schema(implementation = ErrorDTO.class))
                    })
    })
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
